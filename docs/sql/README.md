# 数据库使用注意事项

- 基本问题

1. 在系统中运行的SQL查询，先考虑一下能不能在Slave上检索，目前各个项目中Master上的不可避免的查询量是其他所有的Slave总和还多。
但也不是一味的都是在Slave上查询。
系统上出过一次查询数据的情况：在一个前后顺序执行的逻辑代码中，先更新Master的数据，再在Slave上查更新后的数据，这样的操作很多时候因服务器和网络环境而出现查询结果不一致的情况。这样的就不能在Slave上查询了。

2. 尽量不要输出没有用的列，也不要输出已经明确的列，增加了无用的数据传输量也是影响性能的。

3. 尽量在每个查询中返回自己需要的那些行，无关的不要返回。对简单查询是这样，对复杂的包含很多子查询中的每个子查询更是这样，尽量让每个子查询的结果集保留到最小再进行关联，避免出现先关联后再取Distinct 这样的操作。

4. 尽量不要在程序里面有 Select * 这样的写法，以后表字段的顺序变动都可能造成程序的问题。

5. 对多表之间的连接必须用索引来作为连接列，否则这样的查询就是一个全表扫描，两边的关联字段一定要类型一致，避免强制转换。
    ```sql
    mysql> explain select count(*) From JHF_ALIVE_EXECUTION E ， JHF_ALIVE_CONTRACT C where C。Trade_ID=E。Trade_ID ;
    
    +----+-------------+-------+------+-------------------+-------------------+---------+--------------------+------+-------------+
    
    | id | select_type | table | type | possible_keys | key | key_len | ref | rows | Extra |
    
    +----+-------------+-------+------+-------------------+-------------------+---------+--------------------+------+-------------+
    
    | 1 | SIMPLE | E | ALL | NULL | NULL | NULL | NULL | 866 | |
    
    | 1 | SIMPLE | C | ref | ALIVE_CONTRACT_02 | ALIVE_CONTRACT_02 | 42 | CFDMAIN。E。TRADE_ID | 1 | Using index |
    
    +----+-------------+-------+------+-------------------+-------------------+---------+--------------------+------+-------------+
    
    2 rows in set (0.00 sec)
    ```
6. 不要在Where 字句中对列使用函数，那样会导致索引失效，
    ```sql
    mysql> show index from JHF_ALIVE_CONTRACT ;
    
    +--------------------+------------+-------------------+--------------+-------------+-----------+-------------+-+------------
    
    | Table | Non_unique | Key_name | Seq_in_index | Column_name | Collation | Cardinality | | Index_type
    
    +--------------------+------------+-------------------+--------------+-------------+-----------+-------------+-+------------
    
    | JHF_ALIVE_CONTRACT | 0 | PRIMARY | 1 | CONTRACT_ID | A | 157 | | BTREE 
    
    | JHF_ALIVE_CONTRACT | 1 | ALIVE_CONTRACT_01 | 1 | ORDER_ID | A | 157 | | BTREE 
    
    | JHF_ALIVE_CONTRACT | 1 | ALIVE_CONTRACT_02 | 1 | TRADE_ID | A | 157 | | BTREE 
    
    | JHF_ALIVE_CONTRACT | 1 | ALIVE_CONTRACT_03 | 1 | CUSTOMER_ID | A | 19 | | BTREE 
    
    +--------------------+------------+-------------------+--------------+-------------+-----------+-------------+-+------------
    
    4 rows in set (0.00 sec)
    
    mysql> explain select * From JHF_ALIVE_CONTRACT where Order_ID='20090930CONT00002005' ;
    
    +----+-------------+--------------------+------+-------------------+-------------------+---------+-------+------+-------------+
    
    | id | select_type | table | type | possible_keys | key | key_len | ref | rows | Extra |
    
    +----+-------------+--------------------+------+-------------------+-------------------+---------+-------+------+-------------+
    
    | 1 | SIMPLE | JHF_ALIVE_CONTRACT | ref | ALIVE_CONTRACT_01 | ALIVE_CONTRACT_01 | 82 | const | 1 | Using where |
    
    +----+-------------+--------------------+------+-------------------+-------------------+---------+-------+------+-------------+
    
    1 row in set (0.00 sec)
    ```

    #### 主键检索

    ```sql
    mysql> explain select * From JHF_ALIVE_CONTRACT where substr(Order_ID，1，17) ='20090930ORD000115' ;
    
    +----+-------------+--------------------+------+---------------+------+---------+------+------+-------------+
    
    | id | select_type | table | type | possible_keys | key | key_len | ref | rows | Extra |
    
    +----+-------------+--------------------+------+---------------+------+---------+------+------+-------------+
    
    | 1 | SIMPLE | JHF_ALIVE_CONTRACT | ALL | NULL | NULL | NULL | NULL | 94 | Using where |
    
    +----+-------------+--------------------+------+---------------+------+---------+------+------+-------------+
    
    1 row in set (0.00 sec)
    ```

    #### 全表扫描

    ```sql
    mysql> explain select * From JHF_ALIVE_CONTRACT where Order_ID like '20090930ORD000115%' ;
    
    +----+-------------+--------------------+-------+-------------------+-------------------+---------+------+------+-------------+
    
    | id | select_type | table | type | possible_keys | key | key_len | ref | rows | Extra |
    
    +----+-------------+--------------------+-------+-------------------+-------------------+---------+------+------+-------------+
    
    | 1 | SIMPLE | JHF_ALIVE_CONTRACT | range | ALIVE_CONTRACT_01 | ALIVE_CONTRACT_01 | 82 | NULL | 6 | Using where |
    
    +----+-------------+--------------------+-------+-------------------+-------------------+---------+------+------+-------------+
    
    1 row in set (0.00 sec)
    ```

7. 使用like 语句时，对 “C%”是能利用索引的，但对 “%C”是无效的。而且在前面这个固定字符串越多时效率越好，也就尽量多匹配。

8. Not in 是个危险的用法，在程序中慎用，必要时可以用 left outer join 来改写。

9. 少用点 or ，它很可能会使一个查询索引失效，必要时可以用 union all 或者 union 来替代。

10. 注意一下 Union all 与 union 的区别。前者是两个结果集的不会经过任何处理进行相加，而后者是要经过合并以后的内容。
    对两个毫不相关的集合合并时，尽量用UNION ALL，避免不必要的排序浪费系统资源。

11. 在大表上不做Group by 操作，如果需要的话，可以用大表的总结表。对一些避免不了的实时检索，可以考虑用索引覆盖的方式来对所用到的字段全部建立索引的方式来加快查询速度。

12. 对 Group by ，distinct 出来的结果已经是有序的了，不需要再排序，尽量使用已经排好序的数据，免得再排序浪费资源，如果要排序，不要在Order by 里面的使用表达式。

13. 在java中尽量使用 prepareStatement 来替代 Statement，  一个SQL提交给MYSQL后经历词义检查、语义检查、对象检查、获取存取路径、形成最终执行计划、生成执行代码，但是如果是两个一样的SQL(一模一样，多个空格都不行)这个过程就全部省了，使用绑定变量（有的地方可能称主机变量，就是用？来替代值，然后再设置这个值）能达到一模一样的效果，DBMS在算存取路径的时候会估算一个值来替代，这样能达到一个很好的效果。(如果不注意这一点，那么你的系统离崩溃就不远了，这点对程序员特别重要！！)但是也不是所有的情况都是这样，对一个SQL“长时间固定不变的环境中”，那么每次执行都是相同的SQL，这时静态变量和绑定变量方式唯一的差别是获取存取路径方式的不同，绑定方式是估算，而写成变量的方式是精确的路径。实际中到底使用哪种？1)一般都按照绑定变量来写。２）如果在设计的时候就能明确该句在使用执行的环境，再换成静态方式。其实 都用绑定变量这种方式来写，没有什么坏处！

14. 不要轻易利用MySQL 的自动类型转换，看起来挺好使，但用起来危害非常大，因为它很可能会让看起来好端端的索引失效。

15. 在数据库上经常在允许为NULL的字段上建立了索引，注意想查询此字段上的 is null 或者 is not null 可能会使索引失效。

16. 避免出现 跨库操作这样的SQL语句，例如：

     Use MAIN ;

     Insert into JHF_ORDER select * From HISTORY。JHF_ORDER where id=’33’ ;

         这样的SQL在 Master 上能正常运行的，但是因为Slave 的结构各种各样，对不存在 HISTORY 库的SLAVE，这个SQL 就会导致同步中断，而一般需要人工干预才能继续同步。

17. 现有的数据库结构中各个Slave所忽略的表是不一样的，对类似这样的SQL:

     Insert into TA select * From TB where Code=’ABC’ ，在Master 上执行没问题，但如果某个Slave忽略了TB 表的同步，那么在这个Slave上的TA表的数据将也不会正常，在程序中避免出现一个Insert/Update/Delete中关联多个表的情况，很容易因为Slave同步部分表的原因而导致数据不一致。

18. 对一个大的结果结进行排序是个非常费系统资源的操作。但也不能因为这点而不排序。对一个未使用任何排序操作的结果集的默认顺序是按照主键的顺序进行默认排序的，没有主键或者自增长主键的是按照记录的插入先后顺序进行输出，某些时候是满足需求的，但是这样的排序是不可靠的，在数据库进行过数据重整和索引重建或者后插入的数据的主键值不是按照一个固定的顺序来的时候，就很可能打乱原始的顺序而出现不用时间的不用的检索结果。

19. 关于批处理的SQL，编写时要考虑SQL更新的速率和数据量的大小。 这主要是考虑到我们现在所使用的M/S同步机制。更新速度过快可能使数据库压力增大，并且出现数据库同步延迟。更新太慢没有效率。总之，一定要通过测试综合进行考虑，找到平衡点以达到最好的效果。

20. 不要在正式系统里面运行没有试过的SQL 语句，即使是Select 语句。

    * 不恰当关联，造成笛卡儿结果集非常庞大，让系统忙死在写入临时文件的操作中，这个会发生在两个大表间关联的时候，关联的条件是多对多的关系，造成结果集非常庞大，一时半会都执行不完，这时不要慌，关闭终端是解决不了问题的，进入MySQL或者在客户端终端，按照以下命令：

        show processlist ;  --找到State 处于 Copy to tmp..这样的SQL对应的Id号

        kill XXXX ;

        **才算真正控制了这个SQL的执行。**

    * 要清楚“的确”存在能把数据库整死的纯查询SQL，看起来不起眼，但威力很大，有些是因为MySQL本身的BUG，例如：
        ```sql
        SELECT COUNT(*) FROM (
            SELECT Customer_ID FROM JHF_DEPOSIT
              UNION ALL
            SELECT Customer_ID
            FROM JHF_WITHDRAWAL ORDER BY CustomerID
        ) A ；
        ```
        因为在子查询中Order by 了一个不存在的字段，不是报语句的错误，而是直接将MySQL数据库重启了。
        ```sql
          select A.CC，A.bid，A.ask，A.rateTime，
                 (select ratetime From wxlTemp B 
                  where B.CC=A.CC and B.bid <> A.bid 
                  and B.ask <> A.bid and B.ratetime > A.ratetime 
                Order by ratetime limit 1) as LastTime 
          From wxlTemp A
          where A.RateTime <'2009-07-03 06:03:00'
          Order by A.CC，A.ratetime
        ```
        这个SQL也会导致MySQL数据库重启。

- 有关分页相关的：

1. 分页查询时，通常一页记录为几十条，每次只需要查询当页的记录。当有复杂的查询sql时，我们要将sql分解，提炼出必要的影响结果集的sql，用于分页查询，这个sql只包含一部分主要的表；在分页查询执行后，再查询这一页记录对应的其它表的记录。因为记录数只有一页了，那么其它表的查询的性能将会很好，这部分是需要在java程序中处理的。

2. 如果仅仅统计表记录数量，那么就不要使用order by。

3. 对于分页查询，通常需要显示符合条件的总记录数、页码、当页条数。这样就需要执行两次数据库查询，一次是计算总记录数，一次是检索当页全部记录。对于复杂sql，建议将这两次查询使用的sql分开。这么做的原因是，比如在FX项目中，分页方法一般都是将sql 直接进行解析，根据from来拆分成统计记录数和返回结果集的sql。对于返回当页记录的sql来说，一些where条件和表关联是必要的，因为可能其中一些只是为了在select中包含部分表的字段；但是对于统计记录数的sql来说，只需要那些影响结果记录数的必要条件和关联的表即可。
比如：
    ```sql
     select * from tableA inner join tableB on(tableA.c1=tableB.c1)
     left outer join tableC on (tableC.c2=tableA.c2)
    ```
    tableA 和 tableB的记录是一对一的关系 通用分页方法会将统计记录数的sql分解为类似下面这样：

    ```sql
     select count(*) from tableA inner join tableB on(tableA.c1=tableB.c1)
     left outer join tableC on (tableC.c2=tableA.c2)
    ```
    但是 tableB 是不需要关联的，因为不影响记录数。那么我们单独写一个统计记录数的sql：
    ```sql
     select count(*) from tableA inner join tableB on(tableA.c1=tableB.c1)
    ```

- 如何避免出现锁冲突及死锁

1. 对一个象Fx这样的分布系统，同时操作注文约定逻辑几个表这样的模块有很多，一定要在一个事务中确保所有的模块对操作相同的几个表的顺序都一致，避免多个进程间对表产生死锁。
   
2. 对由不同的模块更新相同的一批记录也可能存在记录间出现死锁的情况，所以对事务操作比较密集的地方，尽量对操作的记录进行按照一个统一的顺序进行，比如升序或者降序。
   
3. 对更新比较频繁的表一定要使用INNODB的表而不要使用MyISAM ，因为MyISAM 的每一次更新都将是锁住整个的表，而大大降低了更新的并发性能。
   
4. 在现有的系统中，我们使用的事务隔离级别是：READ_COMMITED ，在一个事务中它会对更新的记录进行加锁，这里的“更新的记录”比较微妙，它锁定的范围是和更新的语句的where 条件密切相关，想要达到行锁的效果，Update语句的条件一定要加上索引，最好是主键或者唯一键，
   因为这样的锁会很本分，确定的记录比较明确。
   
5. 要尽量保证事务不要过大，小事务发生锁冲突的几率较小。


- 如何优化

    对每个SQL语句在执行之前，做一下 EXPLAIN 检查，查看是否都使用了索引，是否使用了有效的索引，看是否扫描了很多行数据。
    
    对索引的创建也要把握精而不滥的原则，对特殊的表，可以考虑只在Slave上建立。
    
1. 索引的建立对提高检索能力很有用，但是数据库维护它很费资源。
    
2. 索引只使用开头的部分。
    
    key (a，b).... where b=5 will not use index.
    
3. 建立一个对检索有用的索引，
    
    index on gender is not a good idea，例如在性别上建索引不是很有用。
    
4. 对唯一建的索引，加上UNIQUE。
    
5. 避免出现无用的索引。（从来没被调用）
    
6. 索引的顺序很重要。
    
7. 不要在同列(s)上建立两个索引。
    
8. 充分用别的组合索引的前面部分，是个相当好的主意。
    
9. 可以只对一个字段的前几个字段建立索引。
    
10. 短一些的索引比较好，整数最好。(Short keys are better， Integer best)
    
11. 有规律的值 比 没有规律的随机的数要好。
    
        – access locality is much better
    
        – auto_increment better than uuid()

12. 记得经常 优化表，这样能压缩和排序索引项。
    
        OPTIMIZE TABLE compact and sort indexes
    
13. 分析表，能更新表的统计信息，这样对检索很有好处。
    
        ANALYZE TABLE - update statistics
    
14. 利用索引并不一定能提高性能，如果返回结果集数量很大，甚至接近全表记录数时，那么全表扫描的效率更高。通过索引再定位到物理记录，这个过程会比较耗费时间。

- 附录：

    MySQL中通过 show status 对得到的值进行计算得到后的值，大家可以参考。
    
1. 连接失败的监控。
    * 监视点 : 连接失败的百分比。
    * 公式 : Aborted_connects*100 / Connections
    * 正常范围 : 小于 10%。
    * 含义 : 应用程序连接服务器失败的比例，一般原因有:未授权访问数据库/密码错误/连接超时 等。
    
2. 监视点   : 连接失败的百分比。
    * 公式 : Aborted_connects*100 / Connections
    * 正常范围 : 小于 10%。
    * 含义 : 应用程序连接服务器失败的比例，一般原因有:未授权访问数据库/密码错误/连接超时 等。
       
3. 最大情况下的连接使用百分比。
    * 监视点   : 最大情况下的连接使用百分比。
    * 公式     : Max_used_connections / max_connections
    * 正常范围 : 小于 75%。
    * 含义     : 从开机到现在的最大连接情况，表示的是这段时间的峰值，对繁忙的系统这个很有参考意义。
    
4. MyISAM索引缓存命中率
    * 监视点   : key_buffer_size的设置是否适当。
    * 公式     : 1-(Key_reads / Key_read_requests)
    * 正常范围 : 95%以上。
    * 含义     : 增大key_buffer_size并且监控缓存利用率。当命中率到达了一个可接收的水平，保存key_buffer_size值到MySQL配置文件中。 需要MySQL运行一个合理时间后，查看命中率才有意义。
       
5. InnoDB缓存命中率
    * 监视点   : innodb_buffer_pool_size的设置是否适当。
    * 公式     : 100* (1 - (Innodb_buffer_pool_reads / Innodb_buffer_pool_read_requests))
    * 正常范围 : 95%以上。
    * 含义     : 数据和索引在缓存中读取的比率。从内存读取要比磁盘读取块很多，因此要尽量保持物理I/O最少。 当使用InnoDB大多数的访问应该在内存中，因此这个值要很高。
       
6. InnoDB缓存写入等待率
    * 监视点   : innodb_buffer_pool_size的设置是否适当。
    * 公式     : 100* (Innodb_buffer_pool_wait_free / Innodb_buffer_pool_write_requests)
    * 正常范围 : 1% 以下。
    * 含义     : 为了最佳性能，InnoDB不应等待页写入到InnoDB缓冲池中。
       
7. InnoDB 回滚日志写入的等待比率
    * 监视点   : innodb_log_buffer_size的设置是否适当。
    * 公式     : 100* (Innodb_log_waits / Innodb_log_writes)
    * 正常范围 : 1% 以下。
    * 含义     : 为了最佳性能，InnoDB不应等待SQL操作写入到日志。
       
8. 线程缓存大小设定值是否合适
    * 监视点   : thread_cache_size的设置是否适当。
    * 公式     : (1-Threads_created/Connections ) *100%
    * 正常范围 : 95% 以上。
    * 含义     : 每个MySQL连接都运行在它特有的线程中。线程建立比较耗时，因此每个连接关闭的时候不是杀死线程。 服务起能保存线程在线程缓存中稍后为新的连接使用，线程缓存命中率。如果这个值太小那么就要考虑增加线程缓存的大小。
       
9. 表打开操作是否频繁
    * 监视点   : table_cache的设置是否适当。
    * 公式     : Opened_tables 的值，服务器运行一段时间后的值，要是一直在增长，那么就是有问题。
    * 正常范围 : 0 。
    * 含义     : MySQL每次访问表就把它放在表缓存中。如何系统访问很多表那么在缓存中会更快一些。Opened_tables就是没有通过表缓存中打开表的数量，如果这个数值高或者增长的很快那么就需要增加table_cache的值。
       
10. 查询缓存碎片情况
    * 监视点   : 查询缓存中各个使用块的情况，如果单个块中有空闲的，那么此项监控就高。
    * 公式     : 100 * Qcache_free_blocks / Qcache_total_blocks
    * 正常范围 : 低于 70% 。
    * 含义     : 如果你有很多小的查询结果，这个值可能会很高，请考虑下面的选项：
            
            1、减少query_cache_min_res_unit值
            2、执行FLUSH QUERY CACHE对查询缓存进行碎片整理。
       
11. 查询修剪（从缓存中删除，因为内存不够）与插入查询缓存的比率。
    * 监视点   : 从查询缓存中删除的总体量和插入的的比例。
    * 公式     : Qcache_lowmem_prunes / Qcache_inserts
    * 正常范围 :
    * 含义     : 放入缓存的数量 与 被迫从缓存中挤出去的数量的比值。 被挤的情况有某个查询结果集太久没有复用，来了新的结果集，缓存中没有空了。 也可能是，缓存的结果集涉及到的表更新比较频繁，在下次利用的时候，
    发现已经是脏的数据了，于是就挤出来，在重新装载。 这个值能反映出 查询缓存是不是一个稳定的查询缓存，有没有必要使用查询缓存。
       
12. 查询缓存命中率（从缓存中删除，因为内存不够）与插入查询缓存的比率。
    * 监视点   : 一个查询的结果能被复用的比例。
    * 公式     : Qcache_hits / (Qcache_inserts + Qcache_hits)
    * 正常范围 :
    * 含义     :  查询缓存应该为此一个高的命中率。高命中率表示其他的连接可以使用查询缓存中结果。
    低命中率说明没有足够的内存分配给它，或者查询没有在服务器上再三的执行。

13. sort_buffer_size 的大小是否合适。
    * 监视点   : 排序算法已经执行的合并的数量。如果这个变量值较大，应考虑增加sort_buffer_size系统变量的值。
    * 公式     : Sort_merge_passes
    * 正常范围 :
    * 含义     :  
          
14. read_rnd_buffer_size 的大小是否合适。
    * 监视点   :  暂时无
    * 公式     : 
    * 正常范围 :
    * 含义     :   当排序后按排序后的顺序读取行时，则通过该缓冲区读取行，避免搜索硬盘。
    将该变量设置为较大的值可以大大改进ORDER BY的性能。但是，这是为每个客户端分配的缓冲区，
    因此你不应将全局变量设置为较大的值。相反，只为需要运行大查询的客户端更改会话变量。
       
15. read_rnd_buffer_size 的大小是否合适。
    * 监视点   :  表锁的次数。
    * 公式     :  Table_locks_waited / (Table_locks_waited + Table_locks_immediate)
    * 正常范围 :  10% 以内
    * 含义     :  对 MyISAM 表，所表是发生在读和写他们两两之间的，是并发性很低的，所以如果这个值高的话，
    需要拷考虑进行表类型的更改。

16. Percentage of full table scans
    * 监视点   :  全表扫描的比率。
    * 公式     :  (Handler_read_rnd_next + Handler_read_rnd) / (Handler_read_rnd_next + Handler_read_rnd + Handler_read_first + Handler_read_next + Handler_read_key + Handler_read_prev)
    * 正常范围 :  20% 以内
    * 含义     :  要尽力保持很小的值。设法隔离没使用索引的查询。使用慢查询日志记录哪些运行时间较长的查询。
       
17. Select_full_join
    * 监视点   :  没有使用索引的联接的数量。
    * 公式     :  Select_full_join
    * 正常范围 :  20% 以内
    * 含义     :  没有使用索引的联接的数量。如果该值不为0，你应仔细检查表的索引。

18. binlog_cache_size 的大小是否合适。
    * 监视点   :  表锁的次数。
    * 公式     :  Binlog_cache_disk_use / Binlog_cache_use
    * 正常范围 :  10% 以内
    * 含义     :  增加这个值并且监控这个值。当命中率达到可以接受的水平将binlog_cache_size参数添加到MySQL配置文件中。
       
19. tmp_table_size， max_heap_table_size 的大小是否合适。
    * 监视点   :  使用临时表的次数。
    * 公式     :  Created_tmp_disk_tables / Created_tmp_tables
    * 正常范围 :  50% 以内
    * 含义     :  如果这个值太高了那么就要考虑增加tmp_table_size和max_heap_table_size大小。
    临时表的TEXT or BLOBS 字段要保存在磁盘上，因此设法改变TEXT或者BLOBS字段类型。
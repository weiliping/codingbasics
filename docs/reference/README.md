# 程序员练级攻略：程序员修养
 - Bad architecture causes more problems than bad code.
 - You will spend more time thinking than coding.
 - The best programmers are always building things.
 - There's always a better way.
 - Code review by your peers will make all of you better.
 - Fewer features for better code is always the right answer in the end.
 - If it's not tested, it doesn't work.
 - Don't reinvent the wheel, library code is there to help.
 - Code that's hard to understand is hard to maintain.
 - Code that's hard to maintain is next to useless.
 - Always know how your business makes monkey, that determines who gets paid what.
 - If you want to feel important as a software developer, work at a tech company.
 - [The Greatest Developer Fallacy Or The Wisest Words You’ll Ever Hear](https://skorks.com/2011/02/the-greatest-developer-fallacy-or-the-wisest-words-youll-ever-hear/) 

# 关系型数据库（主要为 Mysql）
- 数据库三范式 分别说一下范式和反范式的优缺点
- Mysql 数据库索引。B+ 树和 B 树的区别
为什么 B+ 树比 B 树更适合应用于数据库索引，除了数据库索引，还有什么地方用到了（操作系统的文件索引）
- 聚簇索引和非聚簇索引
- 前缀索引和覆盖索引
- 介绍一下数据库的事务
- Mysql 有哪些隔离级别
- Mysql 什么情况会造成脏读、可重复度、幻读？如何解决
- Mysql 在可重复度的隔离级别下会不会有幻读的情况，为什么？
- Mysql 事务是如何实现的
- Binlog 和 Redo log 的区别是什么，分别是什么用？
- 谈一谈 MVCC 多版本并发控制
- Innodb 和 MyISAM 的区别是什么
- Innodb 的默认加锁方式是什么，是怎么实现的
- 如何高效处理大库 DDL
- Mysql 索引重建
- 对于多列索引，哪些情况下能用到索引，哪些情况用不到索引
- 为什么使用数据库索引可以提高效率，在什么情况下会用不到数据库索引？
- 共享锁和排他锁的使用场景，
- 关系型数据库和非关系数据库的优缺点
- Mysql 什么情况会造成慢查，如何查看慢查询
- 如何处理慢查询，你一般是怎么处理慢查询的
- Mysql 中 varchar 和 char 的区别
- 数据库外键的优缺点
- 有没有使用过数据库的视图
- Mysql 中插入数据使用自增 id 好还是使用 uuid，为什么？
- Mysql 有哪些数据类型，使用的时候有没有什么注意点
- Mysql 集群有哪几种方式，分别适用于什么场景
- Mysql 主从模式如何保证主从强一致性
- Mysql 集群如何保证主从可用性
- Mysql 读写分离有哪些解决办法
# 非关系型数据库
- redis 的底层数据结构有哪些
- redis 中的 SDS 和 C 语言中的字符串有什么区别，优点是什么
- redis 中的字典是如何实现的，如何解决冲突和扩容
- redis 的跳表的使用场景是什么，可以实现一下吗
- redis 缓存穿透，缓存击穿，缓存雪崩，热点数据集中失效 （常问）
- redis 的淘汰策略，来写一下 LRU 吧
- redis 的持久化方式，RDB 和 AOF 分别的使用场景
- redis 如何处理事务
- redis 为什么那么快？
- redis 是单线程为什么还那么快？
- redis 的操作为什么是原子性的，如何保证原子性
- redis 集群用过哪些方案，分别怎么做。讲一下一致性哈希
- redis 什么情况下会出现性能问题，有什么处理办法？
- 有没有使用过 redis 的分布式锁，有什么优缺点
- 说一下 redis 的内存模型
- 说一下 redis 和 memcache 的区别
- 你用 redis 做过什么？（这里尽量不要讲只做过缓存，可以说一下队列，排行榜/计数器，发布/订阅）
- 你用过哪些非关系型数据库，都有什么特点，使用场景分别是什么（体现你技术广度的时刻到了，尽可能多说，但是不会的不要说，防止被问死）
- Mongodb 相对于 Mysql 有哪些优势，底层索引使用的数据结构是什么，为什么要使用这个
- Mongodb 中的分片是什么意思
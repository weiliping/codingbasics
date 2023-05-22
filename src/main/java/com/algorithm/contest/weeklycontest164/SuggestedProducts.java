package com.algorithm.contest.weeklycontest164;

import static com.algorithm.utils.CommonUtils.printArrayList;

import java.util.ArrayList;
import java.util.List;

public class SuggestedProducts {
    public static void main(String[] args) {
        SuggestedProducts s = new SuggestedProducts();
        // String products[] = new String[] { "mobile", "mouse", "moneypot", "monitor",
        // "mousepad" },
        // searchWord = "mouse";
        // print(s.suggestedProducts(products, searchWord));
        //
        // String pros2[] = new String[] { "havana" }, searchWord2 = "havana";
        // print(s.suggestedProducts(pros2, searchWord2));
        //
        // String pros3[] = new String[] { "bags", "baggage", "banner", "box", "cloths"
        // }, searchWord3 = "bags";
        // print(s.suggestedProducts(pros3, searchWord3));
        // String pros4[] = new String[] { "havana" }, searchWord4 = "tatiana";
        // print(s.suggestedProducts(pros4, searchWord4));

        String pros5[] = new String[] { "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnunqerptgas",
                "zmmirsxdhyxvmdybjzondyvrkzeafhvualsivfueweuusmsxbttdeofzeripaqv",
                "tyqcpfvorznmxxdzepfxabibcagilwjsqncxnpjqsxjzqqqbae",
                "tyqcpfvacyrjvmadrmntxotgvgivdvcuwygpjfwcuppunolukrum", "tyqcpfvrqwrcpusmfyhxaiasfbb",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqyalwiaj",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchidnpt", "lfjkcljnd",
                "zibrwfpwecubjlsjbkrhnvolnnzrqhdynloplzagwnuhpxhbvpxnqaifnln",
                "ybswoottdgryxtupichpvqjmcoytrwnfgzrrnaejojvpzmttlzw",
                "tyqcplghosxjviooiyddhvzzrhuuwkiosmgafxyajcdyqlmthqkoylxhtxdruw",
                "okoscfpxcndzgbtsozdofgnomtglmoaewgzzjvrxezoq", "cxkwvaytkxgafeltbanhsvxlorigkuxnsxlmhvwqm",
                "iamtabcpdagicnvdvqcfykonsazrbdivxtczpgqgxjrifukmqjw",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbneryahanhrhkal",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnunl",
                "tyqcpfvorznmxxdzsuyushueegfrnlzbydnefcfagqnxglkulegntoml", "zlovtmburfkd",
                "vlzfaamutsfqefpafzffwhvpfw", "bbufxzwpryyakbxuhwwplvdptgybbykqxirsrahsokviihxrawcbgwrktvgacmwtc",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbzw", "kjundphljswl",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqhlqnapfkcqpdb", "stcphvgxvcaysehvrfdfllwvxf",
                "epbtkgnnupbbdqgheyaks", "gilhnlfkdz", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwghy",
                "yswdsvnzucvsdzrmeghevjrfuhoebfedvyvortaxppwqncmspctdcjlwdxfnc", "baizdtmgozykukcrkapsnp",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgcsfjgtwqqubbhjkzmio",
                "iblyydfzztmtyjmgrxvyjwcobfyxcgyrbtnfhhxswxahze", "tyqcpfyggtmjahhpjzwhohvchyofsxwkehq",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniaymgkdduoabmp",
                "gpsqlqorcbqffdxlnijgvzvxilnbkynwscuoymqyg", "eidradnaqjwmucbrgtp",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzopnqxxcxshbhdmippldmcuxlvc",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbfmryrbgicgzqecje",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuze", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqandxbuvshebs",
                "tyqcqqxonxtwakxlrceyknbockvovdwumbjkfrgmudiafbqlflonfavpsrfq", "tyqcpfvorznmxxdzsnkjnrrzpfourbghe",
                "ziarqmfvzqpqhunfxwfwjtetotozkjaszznbtrvtxarysaxq",
                "tyqcpfvorznmxfmlzlcuikpxvahtfbfipjcgmeusshufvnirwcopdnvnop",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvdertpdpdjsngezrnyjxotgonuigmqkgipgb",
                "tyqcpfvorznmxxdzsnkjnrrzpfvfcvufmzzuqrjubsfzp",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqorqffebhoyfvgkspenqpcmvoxpybkjg",
                "oqojrvinnhlwuqllcsabkpfiusfucpjbsxzzhlgduawaqyp",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviaxsw",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqnzudhzclswotlbgdffwiekw",
                "csgadyglxddodloklsegvsbtgtkloklmxkbxxyorcqwybktuzpyeaqasn",
                "tyqitegmijccjwxuwvchbvuvllmgsdugzxdkiqvnllhmsjyskxpzzds",
                "tyqcpfvorznigwmavbguxwhunsshdybhzszxvlnpingqgaghkqzeynbbbhgcxeydir",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnunflh", "tyqcpfvorznmbwmhfmudnurhismirfgvojpdmclw",
                "tyqcpfvjijiwoup", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejemb",
                "tyqcpfvorznmxxdzsnkjhvabtzucyooctzzrgehlsuyinrrnzjilfpalvqgwoey",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchvie",
                "tyqcpfvorznmxxxvjwfgcwegpibuifhfxyomnicutaegshpnschktxknqytritr", "tyqcpfvorznetvhiaobezckojwjbeg",
                "tyqcpfvorzmjabuccipqln", "frutebajqddrtrsmabfmdcgipssymldwscxbbrbpb",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviotvqi",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchxeyrnlh",
                "yaxaddctugikoutgcwqsdekghoemtooljxvysnzqqvgpc", "tyqcpfvorznmxxdzsnkjn",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqggjwxdvqesbgrqei",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckoktdj", "mzwjshgbgbdogqbrhfgbjkrqogyynbdwwkdclsbpynlrhxeucuuo",
                "tyqcpfvorznmxxdzsnkjnrrztrqgpbvvxm", "u", "tyqcpfvorznmxjnsgyirdtzpwywpnrvgadkmdjghlmerbqysaebyge",
                "tyqcpfvorznmxxdzsnkjnrkjelwoqorxsnyjqdnxfava",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchvqqy", "hcav",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviof",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwreznx",
                "yesupowwycvcdbknhrkfyvnpoqtdhcbhybqvhnvgukoohh", "hcvlnbmcrepblcqrvwpfsyevlpyldptubnxkntqhpounxjcw",
                "lwaxzivycjkanvikqpbrvdvjkaclyuyfitwfycsnfwjg",
                "tkruiswrcbzsbkwbhhvjzzuuiayqzbxjosjssacislcvbtcojpmyatkfgyx",
                "ftujoohzvjonlwxwskeydoxpfvbvrdndbhgpuvykif",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqqngbpbdtufkgunalbekxbkpajlgbjtqmswh",
                "tyqcpfvorznmxxdzsnkjnrrzpewgvvnicz", "tyqcpfvorznmxxdzsnkjnrrzpfgknjxnepksgdzwxsbziwdzsiiyarxhtpp",
                "jumcvboxaxjfybdlezcjrarolxjtsuweaigkiudusinfmnczdualqzlpwkm", "tyqcpfvoxegnpqesbaugr", "bteznmwyh",
                "rtbpifxevchngjnlumvtqtpebgtoznvvrzfxqzmcktoxydbstbvukrunnyeqwfd",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejysfrlewzsgukyahggau",
                "mvrrbfbfwyrxooopgcbwmtjfepejyfrqdkyaqencqqlagoilrtdndfyn",
                "tyqcpfvorznmyrzwhjxvhooytltygrakvgkqumrimazzhzoueyqnjz",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviob",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwoyvqczogovza",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvfnzshqqfpr",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjghvqg",
                "zqrnaierpnsigujuxrftdiauazddadqmrwcimxyztwumwzyjcrqvuexnitdecfgo", "xusxbbilivpovzsjvfsdnacipk",
                "tyqcpfvorznmxxdzkbqgrgeolnwhtvlckmiattpmxwwtmlifnexxbgtpjslwhczrjlhr",
                "eiuytvdzhcodcrdgthxynurtpsdyguupijjluucpfinrfnsjkdbbzexfmctejlgvd",
                "tyqcpfudqjrabwwvdvwmsyscnazaxpsjjhetouegipqevvointclztzummwrrbntjlsj", "tyqcpfvobzfvbiuoktjcqjfx",
                "tyqcpfvorznmxxdzsnamc", "ajqpomnpmsayhelmhfehjbvjaeszqigfqyuixbtyjy",
                "jpfxangixfavlhcssecxljksydrjxmaldhwpftinywtbmffsmtslefcuddk",
                "txryxhtutwdrqmpcapbcrlmhzsobueefwfekusmmylr", "etzqiepphjcleaocnwljcdn",
                "tyqcpfvokfxlbmbzmitacnromkoaoxl", "iddmxxcmwecfutbrbqeihhlnypckofuhkbydmljfemzrvlxsuskxkbgviybzu",
                "tyqcpfvorznmxxdzwilcfwrdlfqppdnuvgltuoooppwyomtvtggmsfxsxievdlsyame",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvzquhbkvburnhmerkuabrfcjwanzmfenz", "tyqcpqgaus",
                "zsbcqgctsjdjyfkdvcehawsqzacafwtjmhemfygdahkexvmkqkcehvek", "tyqcpfvorznmxxdzsnkjfesxjshxtlinfjltdfl",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnubpoqoghhgbpew",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdcuudsuqq", "tyqcpgwivyfquxqhbkjbioekqbsd",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnudxocavmwpggka",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvnlxdokehsjhiohwdeyikeajzipztzhwmxc",
                "pmpoycdxttisazazsgiswnsnhdmejpjbygvtjhwqydeugbouekvornbeiwmpehikbz",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwcpoxr",
                "qmgnrjtavzsqtwareroiihendgcvbzbcolvfoanmixxrxdtnmtevvv",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnunix",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetxpdyhmk", "tyqcpfvorznmxxdzsnkjnrfmy",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetaoqgbczdcemzlmqemy",
                "tyqcpfzmlffhifutomuvfvwaqatopvur", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvdvagddprewvlgx",
                "ozmyertmnlwybntwxmpynuynhqdbqhosvjwexzqgvdtnvxexxwwwwhqktmzbfkjfn",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckohyof",
                "rniiqnzbctzeyeeyrxhfzqgbccplsncvtswcrqmevplfzadlulazmpmhdojwaokn",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzakckmtmjxx",
                "tyqcpfvorznmxxdzsnkjnrrzpfgkhdwienfhpsqbyrvotbgchkkmvk",
                "tyqcpfvorznmxxdzsnkjnrrumaqtylptffsjzygeumkahutdmalkqtrhtgrsrqcyyti",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchvioncnr",
                "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchvigzpo",
                "tyqcpfvorznmxxdzsnkjnrrzpfgkeduq", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnccdnakfkhtg",
                "lhehmbyzcnlwvr", "tyqcpfvojuuprlby", "wds", "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqvegfwmtdcrvdb",
                "tyqcpfvorznpkeynkmbbyptclmhxxlyjzejqbcatgfrmkbbmxs", "tyqcpfvorznmiqmfrhihxsagizcrwyaukrjwbbgrxdzknq",
                "ghhlssixrouzbqcpmxzmsnybaygtb", "jndewk",
                "tyqcpfvorznmxxdzsnkjnrrzpdqanmxattjhgnflnoyynevsxvpbwfmfrnlc" };
        String sw5 = "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviotvdticwxwcliylrpvrokbcguhnfvpd";
        printArrayList(s.suggestedProducts(pros5, sw5));
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = build(products);
        List<List<String>> res = new ArrayList<>();
        int n = searchWord.length();
        char[] chrs = searchWord.toCharArray();
        for (int i = 0; i < n; i++) {
            List<String> subRes = new ArrayList<>();
            char c = chrs[i];
            if (root != null) {
                root = root.childs[c - 'a'];
                dfs(subRes, root);
            }
            res.add(subRes);
        }
        return res;
    }

    void dfs(List<String> res, Trie root) {
        if (root == null) {
            return;
        }
        if (res.size() >= 3) {
            return;
        }
        if (root.isEnding) {
            for (int i = 0; i < root.count; i++) {
                res.add(root.str);
                if (res.size() == 3) {
                    return;
                }
            }
        }
        for (Trie p : root.childs) {
            dfs(res, p);
        }
    }

    Trie build(String[] products) {
        Trie root = new Trie();
        for (String pro : products) {
            Trie p = root;
            char[] chrs = pro.toCharArray();
            int n = chrs.length;
            for (int i = 0; i < n; i++) {
                int ind = (chrs[i] - 'a');
                Trie t = p.childs[ind];
                if (t == null) {
                    p.childs[ind] = new Trie();
                }
                p = p.childs[ind];
            }
            if (!p.isEnding) {
                p.isEnding = true;
                p.str = pro;
            }
            p.count++;
        }
        return root;
    }

    class Trie {
        boolean isEnding = false;
        String str = null;
        int count = 0;
        Trie[] childs = new Trie[26];

        public Trie() {
        }
    }
}

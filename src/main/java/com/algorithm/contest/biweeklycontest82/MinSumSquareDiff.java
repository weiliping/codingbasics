package com.algorithm.contest.biweeklycontest82;

import java.util.Map;
import java.util.TreeMap;

public class MinSumSquareDiff {

    public static void main(String[] args) {
        int nums1[] = new int[] {1,2,3,4}, nums2[] = new int[]{2,10,20,19}, k1 = 0, k2 = 0;
        System.out.println(minSumSquareDiff(nums1, nums2, k1, k2));
        System.out.println(minSumSquareDiffI(nums1, nums2, k1, k2));
        System.out.println(minSumSquareDiffII(nums1, nums2, k1, k2));

        int nums11[] = new int[] {1,4,10,12}, nums12[] = new int[]{5,8,6,9}, k11 = 1, k12 = 1;
        System.out.println(minSumSquareDiff(nums11, nums12, k11, k12));
        System.out.println(minSumSquareDiffI(nums11, nums12, k11, k12));
        System.out.println(minSumSquareDiffII(nums11, nums12, k11, k12));

        int[] nums21 = new int[] {64832,79244,72248,18098,39155,96354,56146,16029,74108,86957,30053,425,36611,58933,64515,34037,1085,80731,19630,13312,53746,85493,97998,35117,67333,45167,19685,15118,92295,62463,75400,29548,70329,14115,66514,78404,5762,26248,95550,28800,13764,53017,16235,16942,86928,31591,8216,36921,24349,99756,60706,2981,89002,84126,64617,62524,41584,24493,76857,90252,38926,5376,91205,85759,93597,54169,11115,99564,75204,32330,54482,38684,33838,31482,85308,54806,7083,25391,34371,98432,63457,8912,53165,64,61769,98684,12289,96312,7946,25329,9507,97582,30985,60039,32055,15,54123,68800,3151,80230,66050,86644,62987,93919,47356,20993,95359,15841,89940,18732,44760,68144,59471,36581,59573,45856,71153,19533,83883,69263,62874,39823,15626,92627,58766,20543,80049,15733,88489,72973,99418,95946,77814,40099,8354,78731,31177,65828,76503,90770,212,13575,16125,55009,78143,97868,66489,19064,72979,89329,86190,32523,73906,32604,1433,80029,72772,43577,36632,99891,20043,41555,12351,40753,61698,32947,58645,13738,78301,88211,61840,77635,68421,55050,45543,96461,80406,69076,55170,23005,98670,34672,19663,61083,55314,8310,95294,93513,44953,41947,12319,81447,86009,94335,70408,96786,3743,7175,16244,26970,9179,38321,22081,17609,9817,4127,76926,9188,92273,17315,9888,90707,5338,35550,24520,8270,97770,7251,57143,60049,13728,27017,78232,6607,78471,79540,24862,33460,96018,2948,72142,31283,79808,98742,11042,55842,38774,15878,84633,79349,18841,28705,58962,53461,36598,57229,41932,56827,21797,93051,15893,60430,29712,62192,85934,66181,39277,11654,31173,62250,18962,5132,94720,10640,99829,68184,66001,58518,44763,2909,74021,39739,60850,5441,64781,61557,45971,14947,74939,35810,17609,22661,88399,27566,27147,84580,33872,42179,40011,7303,76005,78141,60453,28120,76336,53333,15339,34774,64383,62721,34991,7738,81882,1657,71297,71299,96329,34556,44695,40566,55563,62276,38665,36933,45625,87008,19717,88660,70330,44401,2740,75172,97900,29492,62029,80353,55822,67196,9416,8552,31162,27573,89498,21152,80897,71716,17842,11949,57932,53725,67727,52756,36775,68260,15060,27899,62557,6612,39206,71657,17791,95718,68387,23521,70114,44865,45422,16708,39998,27837,45649,93043,2858,84135,32516,18835,17429,13239,43773,56551,53352,22319,8013,20793,9593,3764,55047,96281,56062,22875,44516,96851,39311,18714,40767,43786,66491,25195,69379,6731,29536,81529,55796,37259,17167,90648,2552,22911,86525,99618,66314,4658,36295,43751,25601,27634,76206,91759,80620,15899,38937,22514,7282,43988,70577,44488,71548,16239,18269,76427,53534,19514,16292,7356,59597,80455,83907,40952,76651,42928,59366,40203,13026,94286,98218,93220,97744,29394,15511,10517,81445,44187,14502,85752,53057,16312,93581,97856,87341,587,67145,28716,40397,79941,66591,97929,82059,83113,72126,17396,18339,98201,30858,12073,57045,42662,9082,66801,57073,59850,31556,90066,39009,75115,6237,72197,86350,55659,34842,93874,61365,90495,29500,59367,45854,70082,18675,53958,26095,32854,84721,79498,69082,28181,62331,31206,1346,23685,65932,46015,82192,96125,67801,83830,3946,7665,20613,47217,22169,3649,17161,56243,37215,68545,87128,54556,60112,90721,91008,35199,43511,88821,86499,35986,67682,45211,53902,45881,14011,83190,80199,38461,68684,16037,6619,95910,77411,96063,91502,40228,44160,76747,62874,96419,17629,79794,5673,92395,25074,92245,5092,13463,81115,80100,73084,92965,86224,9373,15813,85043,94168,4014,91902,97088,71525,52756,40633,81272,70123,58169,84090,62618,97886,41945,37596,67251,23962,35632,25256,86413,5052,35327,43988,69624,33962,77495,63607,90198,9377,66857,75964,26429,72202,15715,77547,54104,30775,12818,78682,91183,38440,32126,34838,27132,22854,62011,86262,81260,21263,73462,74057,97080,56438,92705,3888,8664,32333,58542,99856,39661,63185,40744,31990,24261,44457,44457,70203,43916,89795,19624,58254,43486,92005,15894,35985,38265,21667,18123,7884,34857,95582,69488,3043,4484,38607,41564,58255,81101,43118,85406,37102,97315,53191,78640,98934,5272,60793,24696,23513,62225,78366,15538,32319,27503,58234,78951,20842,65853,9118,63532,89185,16894,91065,90196,30049,13046,66852,57587,10819,42866,96497,45295,21383,67308,61967,82180,61085,81521,87920,44070,70712,1515,89522,12936,8300,34173,29095,97671,80085,94859,99473,17856,25803,66562,15593,64238,91102,19388,95938,44348,19397,47096,41715,46686,28339,94117,96512,70701,20405,1000,79297,92336,4938,72560,70786,74041,55935,62705,59604,75707,66889,88719,36687,37843,41036,15199,537,58092,19774,77532,38628,58873,792,44241,61815,21777,34573,54699,87636,5159,21517,76563,42485,88220,25856,12347,24343,59385,32897,77418,57031,86851,28127,4070,66966,27934,75861,67380,55322,98412,66095,86916,1339,18521,84946,53492,26564,57259,62919,5699,95116,44570,2032,15237,57557,44338,72025,85972,19175,75884,73245,82045,38680,46954,15070,85505,74340,38896,82890,25683,90803,82941,67637,76821,96646,76777,57529,37604,58352,34139,18764,10909,77257,8519,17357,36058,39934,64174,576,72133,47291,11128,58850,95109,92019,37203,67157,41663,3785,71586,9519,13474,66084,32854,17555,4061,41429,80116,89020,55853,16122,25012,41928,34828,84970,55133,518,46323,6784,36250,2359,76314,62525,85810,60675,78334,9813,40007,2693,30996,37751,63177,32580,92451,40999,83118,57358,40187,41938,84514,4969,56689,22142,85862,11412,18809,92725,1004,56236,23659,76340,23486,87118,69904,32134,62336,75020,24776,79660,57603,39869,19374,25729,55056,11695,58565,13770,37973,38378,69142,1329,440,85379,70313,74435,99395,43558,68412,81404,21984,54850,72606,38869,44841,91284,14950,33842,98965,72394,91372,18175,97919,94327,89040,85909,98592,63136,34546,27548,68,36175,21092,53369,71728,34354,27956,99815,342,71237,25263,87784,73292,14710,64178,93851,39569,82211,85113,65463,64068,61789,93177,52852,2896,45477,79170,45626,2673,27049,19494,69702,69766,31124,92074,99252,86254,4398,22640,79163,34833,63974,10234,5928,69733,32037,54619,67354,88569,70324,54661,81639,86327,26330,3223,66303,99644,23286,35145,99299,97610,65097,42097,44784,76353,89489,35888,99425,8947,92351,47373};
        int[] nums22 = new int[] {12258,26670,19674,70672,91729,43780,3572,68603,21534,34383,82627,52999,89185,6359,11941,86611,53659,28157,72204,65886,1172,32919,45424,87691,14759,97741,72259,67692,39721,9889,22826,82122,17755,66689,13940,25830,58336,78822,42976,81374,66338,443,68809,69516,34354,84165,60790,89495,76923,47182,8132,55555,36428,31552,12043,9950,94158,77067,24283,37678,91500,57950,38631,33185,41023,1595,63689,46990,22630,84904,1908,91258,86412,84056,32734,2232,59657,77965,86945,45858,10883,61486,591,52638,9195,46110,64863,43738,60520,77903,62081,45008,83559,7465,84629,52589,1549,16226,55725,27656,13476,34070,10413,41345,99930,73567,42785,68415,37366,71306,97334,15570,6897,89155,6999,98430,18579,72107,31309,16689,10300,92397,68200,40053,6192,73117,27475,68307,35915,20399,46844,43372,25240,92673,60928,26157,83751,13254,23929,38196,52786,66149,68699,2435,25569,45294,13915,71638,20405,36755,33616,85097,21332,85178,54007,27455,20198,96151,89206,47317,72617,94129,64925,93327,9124,85521,6071,66312,25727,35637,9266,25061,15847,2476,98117,43887,27832,16502,2596,75579,46096,87246,72237,8509,2740,60884,42720,40939,97527,94521,64893,28873,33435,41761,17834,44212,56317,59749,68818,79544,61753,90895,74655,70183,62391,56701,24352,61762,39699,69889,62462,38133,57912,88124,77094,60844,45196,59825,4569,7475,66302,79591,25658,59181,25897,26966,77436,86034,43444,55522,19568,83857,27234,46168,63616,3268,91348,68452,32059,26775,71415,81279,6388,887,89172,4655,94506,4253,74371,40477,68467,7856,82286,9618,33360,13607,91851,64228,83747,9676,71536,57706,42146,63214,47255,15610,13427,5944,97337,55483,21447,92313,8276,58015,12207,8983,98545,67521,22365,88384,70183,75235,35825,80140,79721,32006,86446,94753,92585,59877,23431,25567,7879,80694,23762,759,67913,87348,11809,10147,87565,60312,29308,54231,18723,18725,43755,87130,97269,93140,2989,9702,91239,89507,98199,34434,72291,36086,17756,96975,55314,22598,45326,82066,9455,27779,3248,14622,61990,61126,83736,80147,36924,73726,28323,19142,70416,64523,5358,1151,15153,182,89349,15686,67634,80473,9983,59186,91780,19083,70365,43144,15813,76095,17540,97439,97996,69282,92572,80411,98223,40469,55432,31561,85090,71409,70003,65813,96347,3977,778,74893,60587,73367,62167,56338,2473,43707,3488,75449,97090,44277,91885,71288,93341,96360,13917,77769,16805,59305,82110,28955,3222,89833,69741,38074,55126,75485,33951,47044,13740,57232,88869,96325,78175,80208,23632,39185,28046,68473,91511,75088,59856,96562,18003,97062,18974,68813,70843,23853,960,72088,68866,59930,7023,27881,31333,93526,24077,95502,6792,92777,65600,41712,45644,40646,45170,81968,68085,63091,28871,96761,67076,33178,483,68886,41007,45282,34767,53161,14571,81290,92971,27367,14017,45355,29485,30539,19552,69970,70913,45627,83432,64647,4471,95236,61656,14227,4499,7276,84130,37492,91583,22541,58811,19623,33776,3085,87416,41300,8791,37921,82074,6793,98428,17508,71249,1384,78669,85428,32147,26924,16508,80755,9757,83780,53920,76259,13358,98589,29618,43551,15227,31256,56520,60239,73187,99791,74743,56223,69735,3669,89789,15971,34554,1982,7538,38147,38434,87773,96085,36247,33925,88560,15108,97785,1328,98455,66585,30616,27625,91035,16110,68611,59193,43336,24837,43489,38928,92802,96734,24173,10300,43845,70203,27220,58247,39821,77648,39671,57666,66037,28541,27526,20510,40391,33650,61947,68387,32469,41594,56588,39328,44514,18951,182,93207,28698,17549,5595,31516,10044,45312,94519,90170,14677,76536,88206,77830,33839,57626,87901,96562,17050,86536,24921,11033,37624,61951,14283,23390,79003,19628,68289,24973,1530,83349,65392,26108,38609,91014,84700,87412,79706,75428,9437,33688,28686,73837,20888,21483,44506,3864,40131,56462,61238,84907,5968,47282,92235,10611,93318,84564,76835,97031,97031,17629,96490,37221,72198,5680,96060,39431,68468,88559,90839,74241,70697,60458,87431,43008,16914,55617,57058,91181,94138,5681,28527,95692,32832,89676,44741,617,26066,46360,57846,8219,77270,76087,9651,25792,68112,84893,80077,5660,26377,73416,13279,61692,10958,36611,69468,38491,37622,82623,65620,14278,5013,63393,95440,43923,97869,73957,14734,9393,29606,8511,28947,35346,96644,18138,54089,36948,65510,60874,86747,81669,45097,27511,42285,46899,70430,78377,13988,68167,11664,38528,71962,43364,96922,71971,99670,94289,99260,80913,41543,43938,18127,72979,53574,26723,39762,57512,19986,18212,21467,3361,10131,7030,23133,14315,36145,89261,90417,93610,67773,53111,5518,72348,24958,91202,6299,53366,96815,9241,74351,87147,2125,35062,57733,74091,23989,95059,35646,78430,64921,76917,6811,85471,24844,4457,34277,80701,56644,14392,80508,23287,14806,2748,45838,13521,34342,53913,71095,32372,918,79138,4685,10345,58273,42542,97144,54606,67811,4983,96912,19451,33398,71749,23310,20671,29471,91254,99528,67644,32931,21766,91470,30316,78257,38229,30367,15063,24247,44072,24203,4955,90178,5778,86713,71338,63483,24683,61093,69931,88632,92508,11600,53150,19559,99865,63702,6276,42535,39445,89777,14583,94237,56359,19012,62093,66048,13510,85428,70129,56635,94003,27542,36446,3279,68696,77586,94502,87402,32396,2559,53092,98897,59358,88824,54933,23740,9951,33236,8101,25760,62387,92581,55267,83570,90325,10603,85154,39877,93573,30544,4784,92761,94512,31940,57543,4115,74716,33288,63986,71383,40151,53578,3662,76233,23766,76060,34544,17330,84708,9762,22446,77350,27086,5029,92443,71948,78303,2482,64269,5991,66344,90547,90952,16568,53903,53014,32805,17739,21861,46821,96132,15838,28830,74558,2276,20032,91443,97415,38710,67524,86416,46391,19820,38798,70749,45345,41753,36466,33335,46018,10562,87120,80122,52642,88749,73666,795,19154,86928,80530,47241,52916,18663,77837,35210,20718,67284,11604,41277,92143,29637,32539,12889,11494,9215,40603,278,55470,98051,26596,98200,55247,79623,72068,17128,17192,83698,39500,46678,33680,56972,75214,26589,87407,11400,62808,58502,17159,84611,2045,14780,35995,17750,2087,29065,33753,78904,55797,13729,47070,75860,87719,46725,45036,12523,94671,97358,23779,36915,88462,46851,61521,39777,99947};
        int k21 = 8282876, k22 = 3037585;
        System.out.println(minSumSquareDiff(nums21, nums22, k21, k22));
        System.out.println(minSumSquareDiffI(nums21, nums22, k21, k22));
        System.out.println(minSumSquareDiffII(nums21, nums22, k21, k22));

        int nums31[] = new int[] {10,10,10,11,5}, nums32[] = new int[]{ 1,0,6,6,1}, k31 = 11, k32 = 27;
        System.out.println(minSumSquareDiff(nums31, nums32, k31, k32));
        System.out.println(minSumSquareDiffI(nums31, nums32, k31, k32));
        System.out.println(minSumSquareDiffII(nums31, nums32, k31, k32));

        int nums41[] = new int[] {
                30113,46140,57389,99453,36488,41409,46767,96055,41142,67524,1510,93419,64031,17657,97668,82578,61697,1523,10255,69040,84721,72655,99720,3508,88662,47205,90161,180,56212,59219,92769,77073,37640,1511,77943,45092,99694,84849,45751,35197,54503,2795,68726,520,78809,78915,71863,90118,1362,84340,99701,44716,29936,6898,589,43875,15796,95542,59126,2806,99733,3356,16919,92,80993,2393,3756,60381,60728,91607,24092,5763,292,40624,93104,74362,8980,1857,44593,95872,98690,55189,49564,99831,1369,36272,81670,1465,30822,48011,74982,88088,98706,85710,14172,184,83,2381,71367,49164,869,460,2006,50984,29140,89582,89630,181,37477,99360,22221,28636,53270,99812,7063,70936,7260,60678,46043,80958,11457,92436,1377,90112,1808,88935,23148,28512,91393,79998,33039,64279,98265,92941,42088,53752,8015,25757,84225,64771,11863,74335,98679,34994,74785,50210,45071,91,21975,80093,9415,99678,10981,48622,27523,17418,47445,40522,295,99863,23890,71708,99836,87360,78965,9,98261,87789,96660,20662,94492,52656,30701,60106,97882,90821,4422,9231,34487,60093,116,5952,24066,26052,24801,33623,56934,677,77985,60926,92285,48964,69575,86085,30525,1147,68727,61007,10578,6518,12635,66234,11360,63767,44570,98012,93700,23392,93277,42622,17639,57115,67669,17729,99427,70813,67450,46231,59756,63046,60170,30926,75259,412,2855,69532,80130,3969,94278,77143,91127,79610,97399,99340,65007,23015,76583,38536,16070,72744,45923,698,10779,95172,75028,2843,23513,99313,51787,47264,72126,12003,32442,97940,51696,169,1782,15766,90800,97956,13849,24837,920,72847,9421,14,9151,98628,2705,78638,78977,62367,42073,85032,22072,92283,65389,96481,86750,538,72293,17943,31763,93440,8206,398,36162,76898,94920,97028,1351,78718,99482,17657,9579,68,276,98120,66919,26421,63289,86850,18895,60949,88864,6366,81391,89263,65189,59156,97828,52319,72597,75300,80770,1626,47123,98853,12655,109,91767,21113,3620,1655,7693,81712,99152,50698,3804,12849,54983,80799,52164,11575,97423,48203,8654,87027,19229,93479,94629,6697,83226,69473,17257,71776,86586,94242,61403,33864,99275,14876,32255,29638,80314,98658,88621,1145,24029,20180,72259,11154,61311,22828,82450,34662,121,94504,2163,1089,99792,64411,55568,25499,99364,79976,82884,97457,55538,89419,92458,66730,98118,23948,91553,97732,97667,27957,88551,33662,34689,6583,53832,39623,57405,3400,23659,80061,3105,68624,81661,43157,2472,61189,56348,57691,76765,694,64714,99008,99942,56225,99804,23595,80337,84116,99923,89770,63996,44585,5120,3528,82340,89992,7426,30814,61710,37359,38236,99473,5471,53192,341,98407,94853,57978,8820,9897,35301,57551,67737,55820,69918,98593,83274,53657,641,31356,87158,51450,83638,6847,95939,79540,57614,72973,948,5834,41731,64607,9264,7077,26706,37864,6042,99716,7298,85,86672,8071,82245,99023,87073,60608,48074,92515,5264,3804,86552,77801,11361,99577,99915,76085,97,34480,63027,44114,44275,97869,24791,55081,13995,293,81823,12856,57483,91129,7192,3272,59146,30866,6651,29957,5328,99631,98707,44750,60521,83612,8432,96032,42317,50551,99896,29598,85479,97408,38820,86822,46287,69602,75423,99914,1569,87285,22118,256,14070,565,45936,17073,73383,95748,82047,97250,99526,90762,91885,13043,74696,99920,99271,53754,70990,88042,72480,79331,10632,36,3530,99828,41883,15821,7640,9582,87768,19954,11976,4638,67109,32326,10939,12023,91884,731,64893,34079,34220,89712,68753,99992,58021,70866,56631,13826,43454,59990,61734,73751,99872,1241,98661,7138,98950,35082,99963,45933,8248,22593,36276,1416,31,88959,298,2656,83063,61247,42333,26890,15380,14139,46751,85731,77469,21441,7106,36878,53963,99232,14526,42854,35404,20523,58826,1294,15878,13272,24392,22595,35195,75802,71618,12390,99653,21200,4313,88678,18709,36,48135,99938,1613,5916,83242,98030,67157,9072,53103,45178,74202,38909,41889,53706,1346,1939,89026,94619,76398,41256,39,3661,66353,93501,71,574,47618,36926,98115,83517,93,55070,3549,42083,9743,74358,294,6422,618,83110,16428,20322,99424,6372,99658,40829,26271,19016,21422,99208,63433,83355,99172,95343,99862,872,99760,7158,43,79825,34796,81278,3876,53734,9351,96059,91537,80321,19964,84177,17001,36980,92400,45738,45283,7255,801,6412,95608,78134,29975,44944,40592,37154,21389,80741,26573,2266,82691,55589,97544,56437,89297,42648,69324,86742,15547,96313,20343,6746,81698,28568,23,75204,95935,81936,97754,2598,16254,67816,57489,12463,93234,98064,61664,1048,99646,2676,30587,79977,68414,98835,87596,85363,12868,89748,85977,85505,5298,11571,92260,58,49082,99456,1409,91880,41320,45962,67079,567,18523,74945,9706,99665,72856,21574,96420,33089,531,90906,99894,62703,79031,99917,68223,19513,145,3613,83840,97449,14794,2352,94178,172,98311,3784,83704,5153,33640,32,44224,99937,98036,73735,42228,78084,95254,82369,49634,2722,28728,4889,62412,45845,58991,66633,86763,26122,83433,99639,57503,13033,37812,26553,17943,99925,49564,79821,86141,26241,55313,93217,18202,81536,52416,60336,31913,63628,69103,84379,82162,1086,92670,45964,50336,67024,46017,1054,16066,77007,27768,4176,99760,97775,95747,80377,25496,15,8916,71827,34958,307,96521,95131,2613,53378,40050,796,2611,72057,47921,99925,1446,90804,25066,32,95833,9153,7837,47217,94747,78,62554,17790,94761,89915,21890,651,43236,35147,69154,6788,10723,42640,98050,35775,40563,13188,99284,93870,81235,88411,9191,15243,1090,14748,92596,5224,11174,42925,98102,23463,31620,92064,24898,99551,90769,98176,97734,98045,91388,91122,5662,4428,79228,90275,48446,3963,32566,61480,61021,85771,5254,24505,21190,83327,57192,2417,27695,47066,44239,72629,36914,73412,88732,63639,99724,48230,99764,91407,2701,1091,83993,42575,17647,20533,1555,6908,13429,16768,67497,94276,9318,26913,72944,1544,34157,77327,94395,98428,1438,93063,63352,35728,98644,31046,782,87753,30050,71403,910,35697,92028,30768,61217,99906,84147,1492,69550,35139,65384,90677,52743,31793,74201,22136,555,85654,78910,37111
        };
        int nums42[] = new int[] {
                25048,51198,64371,6588,40650,57332,54256,33631,36105,60277,98766,97396,69042,25224,34,73291,61546,99967,82397,61556,72862,514,548,3541,12133,43392,95224,99928,52479,64283,692,84566,30147,70941,729,48185,35,96591,53358,98612,47010,7835,68759,99731,9341,83954,62518,27625,98891,4141,415,40987,35000,1835,98955,40780,26246,88058,64184,66506,1042,96585,88203,99378,9733,78624,8796,57270,56401,83397,83165,8868,99563,55163,321,2219,3916,1777,52077,33488,21636,50152,97719,8939,98573,28726,10477,98690,25924,55478,67498,81127,5863,9272,9109,99929,99952,7445,66220,67097,97894,99630,99142,56049,21571,82094,8169,71252,26725,1085,22188,25721,56363,2630,77994,75999,99786,43442,41017,73961,18941,123,99962,97074,99214,11837,28209,33675,26388,7646,32995,41439,1094,99935,42110,61754,84514,35742,81129,71081,84013,79210,26229,45737,74902,59583,42168,99981,94116,85132,12508,2426,23860,64491,45506,88411,42408,47196,99584,191,92814,742,75,16097,84029,99817,75474,78969,3475,13210,2026,52624,93125,52576,838,28371,33903,2130,30160,42611,78,888,19193,33003,87250,41210,52959,97862,59479,55862,85363,41393,74642,86053,38169,65035,76298,66071,18063,78830,5080,56146,87563,71251,44720,22136,30000,15908,1284,47686,13682,77055,59428,10296,203,88796,64234,49963,1843,57333,55106,35964,94532,99589,94853,64495,75069,19920,12985,70091,96194,83933,371,170,72252,94166,81731,41487,16631,599,38430,93357,5719,1846,25098,95700,15940,94246,44206,52412,77788,89085,50375,692,51757,98005,99012,31696,85763,21453,89734,96139,99244,67721,14461,99881,85650,20527,66406,86207,68888,67404,35103,90069,17008,10772,45491,19264,82427,97791,1286,25509,16349,4062,3141,97286,98585,66932,94952,18869,71355,86211,235,10228,9426,99237,92880,88,77482,31038,865,94095,11411,67800,96111,3254,10081,99278,70250,66021,93948,57359,76923,75269,3692,16481,47091,1658,9545,99282,15266,92415,96522,94202,14929,25205,1970,68196,95641,83708,49919,18373,59648,4725,34930,58956,85740,5990,82929,86008,94598,11753,80145,59384,17295,64945,82263,94301,68325,30769,105,11150,25285,24574,75251,91269,16733,98072,16899,38101,87157,14754,54010,15252,89694,39726,99988,89437,99416,98950,623,69987,48510,87885,95038,74939,20460,4931,48054,81848,2813,48790,906,80102,88520,459,70839,35524,83511,96077,41773,83649,61384,47116,54135,95635,93671,72495,7722,58601,89240,46262,25005,44097,61415,47571,84353,79047,64693,640,3,56250,201,30840,75216,89158,2676,82822,63964,52154,27158,9164,9739,27497,1785,31831,56670,42984,45089,267,98201,60484,76221,1015,882,65408,81163,9943,30237,62612,59779,45320,74536,248,6796,63575,93309,39657,94109,46383,78571,78988,90917,62389,52547,81516,98354,18647,34669,59544,16714,3966,8722,27121,77346,540,83782,99952,81608,504,78631,1750,17083,60607,40636,279,223,80267,10075,82838,3021,408,100,78973,92648,39543,91306,36869,28311,5183,30486,47956,96344,99478,63839,83715,62550,86066,14057,96775,69889,35929,3245,34997,97040,456,5411,48614,60359,72860,88888,90276,63506,44915,1145,47177,92967,171,43883,89933,41247,51669,79156,47,98520,18472,27164,71373,35404,99332,40897,12013,80305,14917,10745,328,294,85795,84335,84337,3394,1580,1806,50643,92379,94893,79317,64514,73056,99903,81507,80,37201,87577,70026,2122,84741,16919,17034,97321,72172,25109,87549,62153,86845,93591,59829,43462,41373,96941,75989,2741,63088,89358,52712,21406,35970,54927,54168,68684,733,5859,5823,24674,557,45000,96,49038,99988,31421,28792,98604,99796,10304,98838,99956,62974,54117,37295,19671,91857,9072,53628,5926,84531,36025,79242,44100,46408,64,76910,52662,42654,92396,38260,99768,7305,75657,17441,22748,55517,79602,9194,15483,1664,3623,98384,93745,18736,99331,40564,767,99847,11509,83274,832,64064,14135,48779,50215,69139,39030,46506,71689,98681,99052,96576,97556,3838,23334,99915,97165,51703,85939,99873,99851,42554,29966,650,75950,99106,46559,96154,35132,84133,3056,72439,68810,93166,12104,16396,10223,1012,85229,488,36506,98420,13949,98508,1958,1051,93878,1916,1609,2600,99106,1408,99433,99777,86959,97246,2972,75180,46000,3722,97210,19385,73259,93410,89217,22038,31942,86771,45728,40216,71358,98568,98237,87813,60610,39223,52376,47815,32091,44256,9731,34145,99456,87729,55730,360,51374,84259,45741,64261,8095,87696,88753,97587,11809,72431,46800,99940,67663,3385,99919,48732,12267,11194,67939,48955,19776,90129,5789,65386,95287,2177,99858,25524,2899,83254,1825,92652,4205,88749,89903,13847,22063,99433,82689,21053,99925,75966,1185,80162,85029,48317,53081,4655,99759,89461,67750,17153,2259,1718,83998,90263,27954,99843,14466,600,41713,86717,1549,70872,24580,99831,18498,83872,3962,86946,95962,89140,98236,91062,19633,2893,94844,38679,99906,51459,18,734,11347,49445,77935,2720,64547,44594,8893,42273,83539,51901,53092,64510,59394,91827,31189,6961,457,50019,17845,45248,9322,94333,757,45769,86791,93710,15498,48017,12383,89759,19069,44932,49584,26857,58591,64066,91302,75053,99419,83894,70965,68319,2447,50027,72360,12957,69523,37149,68743,2631,517,6054,87870,20431,97017,89435,63385,7805,92653,24372,2904,99591,58415,45088,99114,10064,73106,40353,10,98697,85737,40644,99899,88379,14211,18589,54404,2222,99669,44571,89931,22613,9661,99099,93295,20966,99036,55559,88792,80564,50157,5811,42735,58087,4947,111,88805,84349,15800,67684,8112,98335,91965,87529,82051,3503,88555,5250,99923,94007,29642,87318,1149,1734,658,26875,25640,83717,96189,5800,80907,3348,8831,41313,81050,17485,56573,66058,93229,10291,21391,94776,78288,47187,99823,90119,42003,38319,1043,52876,78450,81591,71191,44688,54602,23530,84505,20685,99466,78926,35020,94101,96732,99901,11946,84062,24252,3086,318,5761,89309,80240,98522,43350,92196,85387,1267,98573,98113,55900,29171,187,25494,52906,82716,93745,78896,98098,32592,37609,32580,43708,195,14361,63879,7162,30004,58159,93786,35512,23009,69145,29870,97745,91295,6760,44076
        };
        int k41 = 6661159, k42 = 4928195;
        System.out.println(minSumSquareDiff(nums41, nums42, k41, k42));
        System.out.println(minSumSquareDiffI(nums41, nums42, k41, k42));
        System.out.println(minSumSquareDiffII(nums41, nums42, k41, k42));

        int[] nums51 = new int[] {11,12,13,14,15};
        int[] nums52 = new int[] {13,16,16,12,14};
        int k51 = 3, k52 = 6;
        System.out.println(minSumSquareDiff(nums51, nums52, k51, k52));
        System.out.println(minSumSquareDiffI(nums51, nums52, k51, k52));
        System.out.println(minSumSquareDiffII(nums51, nums52, k51, k52));

        int[] nums61 = new int[] {7,5,0,12,14};
        int[] nums62 = new int[] {7,5,0,12,14};
        int k61 = 2, k62 = 9;
        System.out.println(minSumSquareDiff(nums61, nums62, k61, k62));
        System.out.println(minSumSquareDiffI(nums61, nums62, k61, k62));
        System.out.println(minSumSquareDiffII(nums61, nums62, k61, k62));

        int[] nums71 = new int[] {1,2,3,4};
        int[] nums72 = new int[] {2,4,5,7};
        int k71 = 0, k72 = 1;
        System.out.println(minSumSquareDiffI(nums71, nums72, k71, k72));
        System.out.println(minSumSquareDiffII(nums71, nums72, k71, k72));
    }

    public static long minSumSquareDiffII(int[] nums1, int[] nums2, int k1, int k2) {
        int[] difs = new int[100001];
        int mInd = 0, k = k1 + k2;
        long count = 0l, ans = 0l;
        for (int i = 0; i < nums1.length; i++) {
            int dif = Math.abs(nums1[i] - nums2[i]);
            difs[dif]++;
            mInd = Math.max(mInd, dif);
            count += dif;
        }
        if (k >= count) {
            return ans;
        }

        while (mInd > 0) {
            if (k > difs[mInd]) {
                difs[mInd - 1] += difs[mInd];
                k -= difs[mInd];
                mInd--;
            } else {
                difs[mInd - 1] += k;
                difs[mInd] -= k;
                break;
            }
        }

        for (int i = 1; i <= mInd; i++) {
            ans += (long)difs[i] * i * i;
        }
        return ans;
    }

    public static long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        TreeMap<Integer, Integer> mp = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int r = divideNum(nums1[i], nums2[i]);
            if (r == 0) {
                continue;
            }
            mp.put(r, mp.getOrDefault(r, 0) + 1);
        }

        int m = k1 + k2;
        while (m > 0 && !mp.isEmpty()) {
            Map.Entry<Integer, Integer> v = mp.pollLastEntry();
            if (v.getValue() >= m) {
                if (v.getValue() != m) {
                    mp.put(v.getKey(), v.getValue() - m);
                }
                int nextKey = v.getKey() - 1;
                if (nextKey != 0) {
                    mp.put(nextKey, mp.getOrDefault(nextKey, 0) + m);
                }
                break;
            }
            int nextKey = 0, nextVal = 0;
            if (!mp.isEmpty()) {
                Map.Entry<Integer, Integer> v2 = mp.lastEntry();
                nextKey = v2.getKey();
                nextVal = v2.getValue();
            }

            int diff = v.getKey() - nextKey;
            int t = m / v.getValue();
            if (t >= diff) {
                if (nextKey != 0) {
                    mp.put(nextKey, nextVal + v.getValue());
                }
                m -= diff * v.getValue();
            } else {
                m -= t * v.getValue();
                if (v.getKey() != t) {
                    int nextK = v.getKey() - t;
                    mp.put(nextK, mp.getOrDefault(nextK, 0) + v.getValue());
                }
            }
        }
        long res = 0l;
        while (!mp.isEmpty()) {
            Map.Entry<Integer, Integer> v = mp.pollLastEntry();
            res += ((long)v.getKey() * v.getKey() * v.getValue());
        }
        return res;
    }
    public static long minSumSquareDiffI(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length, l = k1 + k2;
        long res = 0l;
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int r = divideNum(nums1[i], nums2[i]);
            if (r == 0) {
                continue;
            }
            mp.put(r, mp.getOrDefault(r, 0) + 1);
        }
        if (mp.isEmpty()) {
            return res;
        }
        if (l == 0) {
            return getRes(mp, res);
        }
        Map.Entry<Integer, Integer> cur = mp.pollLastEntry();
        int curVal = cur.getValue(), curKey = cur.getKey(), diff;
        while (!mp.isEmpty()) {
            Map.Entry<Integer, Integer> next = mp.lastEntry();
            diff = curKey - next.getKey();
            int gap = diff * curVal;
            if (l < gap) {
                break;
            }
            l -= gap;
            mp.pollLastEntry();
            curVal += next.getValue();
            curKey = next.getKey();
        }

        // m greats All
        if (mp.isEmpty() && l >= curKey * curVal) {
            return res;
        }
        if (l == 0) {
            res += multipleVal(curKey, curVal);
        } else {
            int t = l / curVal, rest = l % curVal;
            int k = curKey - t;
            res += multipleVal(k, curVal - rest);
            if (rest != 0) {
                res += multipleVal(k - 1, rest);
            }
        }
        return getRes(mp, res);
    }

    static long getRes(TreeMap<Integer, Integer> mp, long res) {
        while (!mp.isEmpty()) {
            Map.Entry<Integer, Integer> v = mp.pollLastEntry();
            res += multipleVal(v.getKey(), v.getValue());
        }
        return res;
    }

    static long multipleVal(int k, int v) {
        return (long) k * k * v;
    }

    static int divideNum(int num1, int num2) {
        return (num1 > num2) ? num1 - num2 : num2 - num1;
    }
}
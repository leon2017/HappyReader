package com.leonwang.app.chinashop.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 当前类注释：LOL
 * Author :LeonWang
 * Created  2016/8/11.15:32
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class VideoEntity implements Serializable{

    /**
     * api : 1
     * code : 200
     * data : [{"desc":"视频时长：42分钟","id":"31653","item_id":"69440","pic_url":"http://avatar.zhangyoubao.com/pic_v1/lol/news/20160809/spic69440h57a9494a.jpg","published":1470713232,"status":"1","title":"若风解说：螺旋振翅暴力27杀  无敌飞天老螳螂","video_url":"http://k.youku.com/player/getFlvPath/sid/747088785342620d5db72_00/st/mp4/fileid/030020010057A9312EB508052C472388735E4B-CD95-0717-A480-1563C327D9CE?k=5fe42a58e5c1eb582412b40b&hd=1&myp=0&ts=2471&r=/3sLngL0Q6CXymAIiF9JUQQtnOFNJPUClO8A56KJJcT8UB+NRAMQ09zE6rNj4EKMxAvRByWf6hitgv75Fv0ffW+8Ed8l8600VAm37L2P/0mHRsHiupaLjD7oZYvEOhzx3o0KvRb9Ms2Ur0NWEC5XDqoiee/VjpMkQyKQmzXb5+8=&ypremium=1&oip=2340490781&token=6245&sid=747088785342620d5db72&did=1470887853&ev=1&ctype=20&ep=8IM%2F45o1xllMZIGkiT5yaZY8agswhCbOhtvH%2BmYU421gl6%2B71xsAP5MUZwyl9DsWM1kSCe0K%2FxtBiyjD6MpUWmZXE5zrKesBi5n8r9uxNlDe6m5a8djlqYVACk5WFDzC"},{"desc":"三进三出瞬间爆炸  赤狐魅惑螺旋升天","id":"31412","item_id":"68901","pic_url":"http://avatar.zhangyoubao.com/pic_v1/lol/news/20160726/spic68901h57970301.jpg","published":1469516400,"status":"1","title":"若风解说 赤狐魅惑螺旋升天","video_url":"http://k.youku.com/player/getFlvPath/sid/3470889377862202094c5_00/st/mp4/fileid/03002001005796F53697C3052C4723F0B761C0-F52B-30CE-1A12-A6E8A6D07101?k=1a9dcb455a900123282ba41e&hd=1&myp=0&ts=2475&r=/3sLngL0Q6CXymAIiF9JUQQtnOFNJPUClO8A56KJJcT8UB+NRAMQ09zE6rNj4EKMxAvRByWf6hitgv75Fv0ffYne6Ht/I4f01jhGGPxvLqdBJSE3YeTHF18nd3XgS/2DNC7PvwS3MIuZ+6COT7rraqoiee/VjpMkQyKQmzXb5+8=&ypremium=1&oip=2340490781&token=2643&sid=3470889377862202094c5&did=1470889377&ev=1&ctype=20&ep=RH8bqvnutCoCfKCTCLLcHYgxpxj6dFH3fscsq3C6U3ObQfLNOAXEG3wJd7X27ZWcVrSb7dBb6XR3b4z4Y9P3wTlrXMsfGMNid%2F2v5EPO0JfrU6AAMgQ1oEOssSI0ZsH1"},{"desc":"无敌元首推三路","id":"31247","item_id":"68622","pic_url":"http://avatar.zhangyoubao.com/pic_v1/lol/news/20160719/spic68622h578d9990.jpg","published":1468899004,"status":"1","title":"若风解说 飘逸球女撸全场","video_url":"http://k.youku.com/player/getFlvPath/sid/8470888243255204ce7b7_00/st/mp4/fileid/0300200100578D8C43E03D052C472347F817E2-755A-A48E-57B3-48F7104D46FC?k=37506e8210e72e592412b40a&hd=1&myp=0&ts=1392&r=/3sLngL0Q6CXymAIiF9JUQQtnOFNJPUClO8A56KJJcT8UB+NRAMQ09zE6rNj4EKMxAvRByWf6hitgv75Fv0ffeUcrA1hvNvZx/YSSgrWt71lclUMSCoQr5Lij+VpOjftTkPtK5pEFb+TvFd3vombvqoiee/VjpMkQyKQmzXb5+8=&ypremium=1&oip=2340490781&token=1844&sid=8470888243255204ce7b7&did=1470888243&ev=1&ctype=20&ep=sSBYQnRhCPtMCeaIhVBolHbhcVQs33sf%2Fm%2F6fwlUwHHB770mW89wLo9rr0UPNow2umMte9HCiZup%2BduiTN5DRa1UDHkZ9ajDhmitXtf0XXSuB3Sasw7wXrQ29qC1a4FU"},{"desc":"五杀核爆电焊工  究极射线秒全场","id":"30743","item_id":"67718","pic_url":"http://avatar.zhangyoubao.com/pic_v1/lol/news/20160628/spic67718h5771d537.jpg","published":1467077171,"status":"1","title":"若风解说 五杀三只手维克托","video_url":"http://k.youku.com/player/getFlvPath/sid/247088695848320c3469b_00/st/mp4/fileid/03002001005771C51D6883052C47238F0E1CBD-7F28-24CD-09D9-FFA05BEB8121?k=2a1fad66b10445b1282ba416&hd=1&myp=0&ts=2457&r=/3sLngL0Q6CXymAIiF9JUQQtnOFNJPUClO8A56KJJcT8UB+NRAMQ09zE6rNj4EKMxAvRByWf6hitgv75Fv0ffe0wQscT1vtnsVeHAXVM/s1si7u5f7C8FuQebmdx46snlghaRJFKtnVwVPnD31dLy6oiee/VjpMkQyKQmzXb5+8=&ypremium=1&oip=2340490781&token=1571&sid=247088695848320c3469b&did=1470886958&ev=1&ctype=20&ep=Mkx8RW433ZcIIiqD4T1cZHmw6yOVnw6NoLBKZX917Ut0gobRalmaQ7z60Kv27PYG0ds%2FFR55ylCNd0IWtqqPvU5Q9wAg0yoEfW16swKuOxNNHolBWgPN363LhqrAD%2Ft3"},{"desc":"史上最悲剧五杀被抢！愤怒的金翅冰鸟！","id":"30582","item_id":"67433","pic_url":"http://avatar.zhangyoubao.com/pic_v1/lol/news/20160621/spic67433h5768b0bc.jpg","published":1466479888,"status":"1","title":"若风解说 愤怒的冰鸟","video_url":"http://k.youku.com/player/getFlvPath/sid/64708859001042019665d_00/st/mp4/fileid/030020010057689B1B3C41052C4723747B6F4C-6D07-3A8F-FB5C-9640138FF850?k=2be64e6482dd2476261f2c11&hd=1&myp=0&ts=3481&r=/3sLngL0Q6CXymAIiF9JUQQtnOFNJPUClO8A56KJJcT8UB+NRAMQ09zE6rNj4EKMxAvRByWf6hitgv75Fv0ffW0CdC40A2VNlpJcfLu9WEbf6GARwNvgetiXbNl5yFAeH22tgjsALlS08L577SqhT6oiee/VjpMkQyKQmzXb5+8=&ypremium=1&oip=2340490781&token=1992&sid=64708859001042019665d&did=1470885899&ev=1&ctype=20&ep=oK%2B0ZGoic9lNBEFSkOxrB7rueVjIlcgJIo9eFNKfywr9SarWvezy4NLWbuT3h3AekHcr5KFvo7Myx293pcQtJfIX9h6A%2FDYVoOUfboRYczUbDIhfvf3WiH09WRn%2Fa0Bd"},{"desc":"大师归来，正真的武器1V9！","id":"30483","item_id":"67177","pic_url":"http://avatar.zhangyoubao.com/pic_v1/lol/news/20160616/spic67177h576249b4.jpg","published":1466067600,"status":"1","title":"若风风神榜 武器大师归来","video_url":"http://k.youku.com/player/getFlvPath/sid/3470895752319207363cb_00/st/mp4/fileid/0300200100576218C4CF2B052C4723710FE169-C540-E4DF-B74D-F9ABA4405961?k=db1208e5901b15e9261f2c1e&hd=1&myp=0&ts=857&r=/3sLngL0Q6CXymAIiF9JUQQtnOFNJPUClO8A56KJJcT8UB+NRAMQ09zE6rNj4EKMxAvRByWf6hitgv75Fv0ffbF8kIVhA7CYCDkc4n5/CX8utd/ccUG2Y048js+sDG3AWQ4sbVzrPW0eLopvF7BveQ==&ypremium=1&oip=2340490781&token=8695&sid=3470895752319207363cb&did=1470895752&ev=1&ctype=20&ep=bYiTiDeS8pZbsMTN6PCGSJhdCmVrhuuZZben9FfWdLuXjF5hvtjpxhS51Ctre5NK1GqDXY2VpfYlTjynMU0U1Qzc9iR9lkqTyGX1%2BG2AmZsCQ1mGHvn6Mgh2ary2kgMg"},{"desc":"若风现场直播如何成功搭讪吴彦祖","id":"30436","item_id":"67101","pic_url":"http://avatar.zhangyoubao.com/pic_v1/lol/news/20160614/spic67101h575fc576.jpg","published":1465894800,"status":"1","title":"当巨魔遇上古尔丹 华谊之夜现场","video_url":"http://video.dispatch.tc.qq.com/31534498/z0020q1qlcd.p203.1.mp4?sdtfrom=v1001&type=mp4&vkey=4149BF014ACA7508570633060403314E3F85E132672CE2229D94F65AD8F0BC794BA537A74350657DDD19B1953510A22FFEA23E9C493A1513CB9694505B6CC683EE716CA6F41EF7ED6B9F9B2F536A472BDBE9E34AB24B25F0CFA96ACEAA8415246E20006767D323F7E3B0A83AD004B2CD&platform=10902&fmt=auto&sp=350&guid=a25ae004eadf95406855ffbad5653993"},{"desc":"溜的飞起！旋转幻影野马践踏全场","id":"30278","item_id":"66830","pic_url":"http://avatar.zhangyoubao.com/pic_v1/lol/news/20160608/spic66830h57578b9d.jpg","published":1465356297,"status":"1","title":"若风解说 旋转幻影野马","video_url":"http://k.youku.com/player/getFlvPath/sid/9470886981557206c72ef_00/st/mp4/fileid/030020010057577C84583A052C4723233B5596-4797-66C0-9C6F-D71275FBC021?k=4281a99edc6c33b4261f2c12&hd=1&myp=0&ts=2366&r=/3sLngL0Q6CXymAIiF9JUQQtnOFNJPUClO8A56KJJcT8UB+NRAMQ09zE6rNj4EKMxAvRByWf6hitgv75Fv0ffZX1GCyU8i1sdNKQTVxcf0yI6cywe4vam936+x7UBAZ77IFpF/mFh7Dmiih7PjXMnKoiee/VjpMkQyKQmzXb5+8=&ypremium=1&oip=2340490781&token=6307&sid=9470886981557206c72ef&did=1470886981&ev=1&ctype=20&ep=rlzPYtSl0nPWAKCaiXAs%2BLJXgdHfa%2BXKGoRBh8mp9XzrsYoTYzR32df3aMUck4HqXs3h0jlcL%2BS6oNS1Zrfqlne%2Bqw7P%2FFtvEoUh%2BwMO7M4Wfjj%2FjN8Hr9JsFBcvTw6L"},{"desc":"最强AOE输出地狱火男燃尽一切","id":"30198","item_id":"66675","pic_url":"http://avatar.zhangyoubao.com/pic_v1/lol/news/20160604/spic66675h575246d2.jpg","published":1465011161,"status":"1","title":"若风风神榜 地狱火男燃尽一切","video_url":"http://k.youku.com/player/getFlvPath/sid/7470896996087209c87e2_00/st/mp4/fileid/03002001005751CF94E34C052C4723BD1B12F0-4970-B822-D35F-9C79CE72893E?k=720e8a877c250fc92412b413&hd=1&myp=0&ts=778&r=/3sLngL0Q6CXymAIiF9JUQQtnOFNJPUClO8A56KJJcT8UB+NRAMQ09zE6rNj4EKMxAvRByWf6hitgv75Fv0ffTdufKtRRR0pXZpj32IxQ83SIbG4DLg/z38nljTthXICFpiQ0t1Z6lliNvSjW/NPIg==&ypremium=1&oip=2340490781&token=7031&sid=7470896996087209c87e2&did=1470896995&ev=1&ctype=20&ep=GKhS8tLtTz55PAVyrN2zQh5klhSPyKshLxyETGOA1ri01PnsLGiJxdSrml8NkNVTSFFhFqnWqLMe0Kk7Qjyu7MNYYMgTRuUnEaJbddnQ69241pJVx6FMrXiu55CHoMBa"},{"desc":"凌波微步秀穿三路 幻影妖姬笑虐全场","id":"30083","item_id":"66476","pic_url":"http://avatar.zhangyoubao.com/pic_v1/lol/news/20160531/spic66476h574d359d.jpg","published":1464678000,"status":"1","title":"若风解说 幻影妖姬笑虐全场","video_url":"http://k.youku.com/player/getFlvPath/sid/9470895490843209a46c9_00/st/mp4/fileid/0300200100574CF24966E1052C4723C3F5B2CE-8017-CD17-5897-00385C14FD94?k=d52f339c14dcd3802412b411&hd=1&myp=0&ts=2814&r=/3sLngL0Q6CXymAIiF9JUQQtnOFNJPUClO8A56KJJcT8UB+NRAMQ09zE6rNj4EKMxAvRByWf6hitgv75Fv0ffZLdWdCtd+eAM0suPm6mICViFFyMw5evqN0aqSqs+PlX81joIkAvgdWhh9PFPzUR9qoiee/VjpMkQyKQmzXb5+8=&ypremium=1&oip=2340490781&token=4370&sid=9470895490843209a46c9&did=1470895490&ev=1&ctype=20&ep=BYnu%2FAiBfZwkWf7%2F57FF80FdJGpG3xv6D6NdmTAcxtc6IKGl%2FOsb1rDCRhevC35eZdnCmnChCj8B6wHWiWAkZ%2FOrq78KbSXhzlDdo%2FFH3hHW%2F45iSScw4SeoIc%2F4H4OV"}]
     * message : ok
     */

    private int api;
    private int code;
    private String message;
    private ArrayList<DataEntity> data;

    public void setApi(int api) {
        this.api = api;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(ArrayList<DataEntity> data) {
        this.data = data;
    }

    public int getApi() {
        return api;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<DataEntity> getData() {
        return data;
    }

    public static class DataEntity implements Serializable {
        /**
         * desc : 视频时长：42分钟
         * id : 31653
         * item_id : 69440
         * pic_url : http://avatar.zhangyoubao.com/pic_v1/lol/news/20160809/spic69440h57a9494a.jpg
         * published : 1470713232
         * status : 1
         * title : 若风解说：螺旋振翅暴力27杀  无敌飞天老螳螂
         * video_url : http://k.youku.com/player/getFlvPath/sid/747088785342620d5db72_00/st/mp4/fileid/030020010057A9312EB508052C472388735E4B-CD95-0717-A480-1563C327D9CE?k=5fe42a58e5c1eb582412b40b&hd=1&myp=0&ts=2471&r=/3sLngL0Q6CXymAIiF9JUQQtnOFNJPUClO8A56KJJcT8UB+NRAMQ09zE6rNj4EKMxAvRByWf6hitgv75Fv0ffW+8Ed8l8600VAm37L2P/0mHRsHiupaLjD7oZYvEOhzx3o0KvRb9Ms2Ur0NWEC5XDqoiee/VjpMkQyKQmzXb5+8=&ypremium=1&oip=2340490781&token=6245&sid=747088785342620d5db72&did=1470887853&ev=1&ctype=20&ep=8IM%2F45o1xllMZIGkiT5yaZY8agswhCbOhtvH%2BmYU421gl6%2B71xsAP5MUZwyl9DsWM1kSCe0K%2FxtBiyjD6MpUWmZXE5zrKesBi5n8r9uxNlDe6m5a8djlqYVACk5WFDzC
         */

        private String desc;
        private String id;
        private String item_id;
        private String pic_url;
        private int published;
        private String status;
        private String title;
        private String video_url;

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setItem_id(String item_id) {
            this.item_id = item_id;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public void setPublished(int published) {
            this.published = published;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setVideo_url(String video_url) {
            this.video_url = video_url;
        }

        public String getDesc() {
            return desc;
        }

        public String getId() {
            return id;
        }

        public String getItem_id() {
            return item_id;
        }

        public String getPic_url() {
            return pic_url;
        }

        public int getPublished() {
            return published;
        }

        public String getStatus() {
            return status;
        }

        public String getTitle() {
            return title;
        }

        public String getVideo_url() {
            return video_url;
        }
    }
}

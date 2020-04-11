package com.example.eventandguest;

import java.util.ArrayList;

public class EventData {
    public static String[][] data = new String[][]{
            {"1", "Paskah", "12 April 2020", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/Presiden_Sukarno.jpg/418px-Presiden_Sukarno.jpg"},
            {"2", "Hari Buruh Internasional", "1 Mei 2020", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/President_Suharto%2C_1993.jpg/468px-President_Suharto%2C_1993.jpg"},
            {"3", "Hari Raya Waisak", "7 Mei 2020", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/Bacharuddin_Jusuf_Habibie_official_portrait.jpg/520px-Bacharuddin_Jusuf_Habibie_official_portrait.jpg"},
            {"4", "Kenaikan Isa Almasih", "21 Mei 2020", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/President_Abdurrahman_Wahid_-_Indonesia.jpg/486px-President_Abdurrahman_Wahid_-_Indonesia.jpg"}
            /*https://api.time.com/wp-content/uploads/2019/04/gettyimages-617733080.jpg
            https://i.pinimg.com/736x/7c/7b/92/7c7b92b99e522cb8d327dbf35f71beb0.jpg
            https://assets-a1.kompasiana.com/items/album/2016/05/23/waisak-1-5742b01dba9373080c4ab318.jpg
            https://pbs.twimg.com/media/DczHo6XXkAAKXls.png
            */
    };

    public static ArrayList<Event> getListData(){
        Event event = null;
        ArrayList<Event> list = new ArrayList<>();
        for (String[] aData : data) {
            event = new Event();
            event.setId(Integer.parseInt(aData[0]));
            event.setName(aData[1]);
            event.setDate(aData[2]);
            event.setImage(aData[3]);

            list.add(event);
        }
        return list;
    }
}

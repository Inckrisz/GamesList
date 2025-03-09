package com.gameslist.gameslist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Map;

@Document(collection = "games")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {

    @Id
    private ObjectId id;
    @Field("img_url")
    private String imgUrl;
    private String date;
    private String developer;
    private String publisher;
    @Field("full_desc")
    private FullDescription fullDesc;
    private String price;
    private String name;
    private List<String> categories;
    @Field("popu_tags")
    private List<String> popularTags;
    private Requirements requirements;
    @Field("url_info")
    private GameUrlInfo urlInfo;



}

@Data
@NoArgsConstructor
@AllArgsConstructor
class   FullDescription {
    private String sort;
    private String desc;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Requirements {
    private Map<String, OSRequirement> minimum;
    private Map<String, OSRequirement> recommended;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class OSRequirement {
    private String processor;
    private String memory;
    private String graphics;
    private String os;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class GameUrlInfo {
    private String url;
    @Field("id")
    private String id;
    private String type;
    @Field("url_name")
    private String urlName;
}
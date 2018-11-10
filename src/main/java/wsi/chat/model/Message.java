package wsi.chat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    Integer id;
    String authorNick;
    String room;

    Date created;

    String content;
    Integer upvote;
    Integer downvote;
    Integer flagvote;
}

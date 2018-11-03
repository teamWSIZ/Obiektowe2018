package wsi.chat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    Integer id;
    String authorNick;
    String room;

    String content;
    Integer upvote;
    Integer downvote;
    Integer flagvote;
}

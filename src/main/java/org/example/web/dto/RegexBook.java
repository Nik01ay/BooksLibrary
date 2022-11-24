package org.example.web.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegexBook {

    private String id;
    private String author;
    private String title;
    private String size;

    public boolean includes(Book book) {
        boolean incAuthor = includesString(book.getAuthor(), author);
        boolean incTitle = includesString(book.getTitle(), title);
        boolean incId = includesString(book.getId().toString(), id);
        boolean incSize = includesString(book.getSize().toString(), size);

        return incAuthor
                && incTitle
                && incId
                && incSize;
    }

    private boolean includesString(String param, String regex) {
       try {

           if (!param.isEmpty()) {
               return param.matches(regex) || regex.isEmpty();
           }

           return param.isEmpty() && regex.isEmpty();
       } catch (Exception e) {
           return false;
       }
    }
}

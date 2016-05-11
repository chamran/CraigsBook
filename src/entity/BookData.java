package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties({
        "edition_info",
        "awards_text",
        "urls_text",
        "title_long",
        "dewey_normal",
        "subject_ids",
        "marc_enc_level",
        "lcc_number",
        "book_id",
        "physical_description_text",
        "summary",
        "dewey_decimal",
        "isbn13",
        "notes",
        "title_latin",
        "publisher_id",
        "language",
        "publisher_text",
        "publisher_name",
        "isbn10"
})
public class BookData {

    @JsonProperty("author_data")
    private List<AuthorData> authorData = new ArrayList<AuthorData>();
    @JsonProperty("title")
    private String title;


    /**
     *
     * @return
     * The authorData
     */
    @JsonProperty("author_data")
    public List<AuthorData> getAuthorData() {
        return authorData;
    }

    /**
     *
     * @param authorData
     * The author_data
     */
    @JsonProperty("author_data")
    public void setAuthorData(List<AuthorData> authorData) {
        this.authorData = authorData;
    }

    /**
     *
     * @return
     * The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

}
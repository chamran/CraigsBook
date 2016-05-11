package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties({"index_searched"})
public class Book {

    @JsonProperty("data")
    private List<BookData> data = new ArrayList<BookData>();

    /**
     *
     * @return
     * The data
     */
    @JsonProperty("data")
    public List<BookData> getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    @JsonProperty("data")
    public void setData(List<BookData> data) {
        this.data = data;
    }

}
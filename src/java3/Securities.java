package java3;

import java.util.List;

public class Securities {

    private String name;
    private List<String> currency;
    private String code;
    private String date;

    public Securities() {
    }

    public Securities(String name, List<String> currency, String code, String date) {
        this.name = name;
        this.currency = currency;
        this.code = code;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCurrency() {
        return currency;
    }

    public void setCurrency(List<String> currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Securities{" +
                "name='" + name + '\'' +
                ", currency=" + currency +
                ", code='" + code + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

}

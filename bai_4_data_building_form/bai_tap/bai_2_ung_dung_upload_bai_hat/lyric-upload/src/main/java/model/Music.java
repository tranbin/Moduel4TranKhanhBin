package model;

public class Music {
    private String name;
    private String singer;
    private String typeOf;
    private String fileUp;

    public Music() {
    }

    public Music(String name, String singer, String typeOf, String fileUp) {
        this.name = name;
        this.singer = singer;
        this.typeOf = typeOf;
        this.fileUp = fileUp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTypeOf() {
        return typeOf;
    }

    public void setTypeOf(String typeOf) {
        this.typeOf = typeOf;
    }

    public String getFileUp() {
        return fileUp;
    }

    public void setFileUp(String fileUp) {
        this.fileUp = fileUp;
    }
}
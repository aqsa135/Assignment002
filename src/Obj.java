public class Obj {
    private String zip;
    private String NAICS;
    private String neighborhood;
    private String type;
    private Boolean open;
    private String startDate;

    public Obj(String zip, String naics, String hood, String type, String sDate) {
        this.zip = zip;
        this.NAICS = NAICS;
        this.neighborhood = hood;
        this.type = type;
        this.startDate = sDate;
    }

    public void setsDate(String sDate) {
        this.startDate = sDate;
    }
    public String getsDate() {
        return startDate;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getZip() {
        return zip;
    }

    public void setNAICS(String NAICS) {
        this.NAICS = NAICS;
    }

    public String getNAICS() {
        return NAICS;
    }

    public void setHood(String hood) {
        this.neighborhood = hood;
    }

    public String getHood() {
        return neighborhood;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Boolean isOpen() {
        return open;
    }


    public String toString() {
        return "(" + this.zip + "," + this.NAICS + "," + this.neighborhood + "," + this.open + "," + this.startDate + ")";
    }
}
package Normal;

public class Candidate {
    private int idNumber;
    private String name;
    private String address;
    private String block;

    public Candidate() {
    }

    public Candidate(int idNumber, String name, String address,String block) {
        this.idNumber = idNumber;
        this.name = name;
        this.address = address;
        this.block=block;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    @Override
    public String toString() {
        return
                idNumber + "," + name + "," + address + ","+ block+"\n" ;
    }
}

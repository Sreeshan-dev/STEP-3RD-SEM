package STEP.WEEK4.HW;
class MovieTicket {
    String movieName, theatreName;
    int seatNumber;
    double price;
    MovieTicket() { movieName="Unknown"; }
    MovieTicket(String m) { movieName=m; price=200; }
    MovieTicket(String m,int s) { movieName=m; seatNumber=s; theatreName="PVR"; }
    MovieTicket(String m,String t,int s,double p) { movieName=m; theatreName=t; seatNumber=s; price=p; }
    void printTicket() { System.out.println(movieName+" "+theatreName+" "+seatNumber+" "+price); }
    public static void main(String[] args) {
        new MovieTicket().printTicket();
        new MovieTicket("Inception").printTicket();
        new MovieTicket("Avatar",12).printTicket();
        new MovieTicket("Joker","IMAX",45,350).printTicket();
    }
}

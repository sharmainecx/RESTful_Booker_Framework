package Context;

public class TestContext {

    private static final ThreadLocal<TestContext> instance = ThreadLocal.withInitial(TestContext::new);

    private int bookingId;
    private String token;

    private TestContext(){

    }

    public static TestContext getInstance() {
        return instance.get();
    }

    public int getBookingId(){
        return bookingId;
    }

    public void setBookingId(int bookingId){
        this.bookingId = bookingId;
    }

    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token = token;
    }
}

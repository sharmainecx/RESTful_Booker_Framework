package Context;

public class TestContext {

    private static final ThreadLocal<TestContext> instance = ThreadLocal.withInitial(TestContext::new);

    private int bookingId;

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
}

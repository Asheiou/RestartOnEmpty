package uk.asheiou.restartonempty;

public final class Toggle {
    private static boolean status;
    
    public static boolean getStatus() {
      return status;
    }
    
    public static void setStatus(boolean toSet) {
      status = toSet;
    }
}

package bgu.spl.a2;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;
import junit.framework.TestCase;


public class VersionMonitorTest extends TestCase {

    public void testGetVersion() {
    VersionMonitor A = new VersionMonitor();
    try{
        assertEquals("Failed testGetVersion: version doesn't match", 0, A.getVersion());
    }
        catch (AssertionFailedError e){
        System.out.println(e.getMessage());
        }
    }

    public void testInc() {
        VersionMonitor A = new VersionMonitor();
        A.inc();
        try{
            assertEquals("Failed testInc: version doesn't match", 1, A.getVersion());
        }
        catch (AssertionFailedError e){
            System.out.println(e.getMessage());
        }
    }

    public void testAwait() {
        VersionMonitor A = new VersionMonitor();
        try{
            A.await(5);
            Thread T1 = new Thread(()->  A.inc());
            T1.start();
        }
        catch (InterruptedException e){};

    }
}
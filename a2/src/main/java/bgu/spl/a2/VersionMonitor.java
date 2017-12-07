package bgu.spl.a2;

/**
 * Describes a monitor that supports the concept of versioning - its idea is
 * simple, the monitor has a version number which you can receive via the method
 * {@link #getVersion()} once you have a version number, you can call
 * {@link #await(int)} with this version number in order to wait until this
 * version number changes.
 *
 * you can also increment the version number by one using the {@link #inc()}
 * method.
 *
 * Note for implementors: you may add methods and synchronize any of the
 * existing methods in this class *BUT* you must be able to explain why the
 * synchronization is needed. In addition, the methods you add can only be
 * private, protected or package protected - in other words, no new public
 * methods
 */
public class VersionMonitor {

    private int version = 0;//The initial version equals to zero
    private Object someLock = new Object();

    public int getVersion() {
        synchronized (someLock) {
            return this.version;
        }
     /*   //TODO: replace method body with real implementation
      //  throw new UnsupportedOperationException("Not Implemented Yet.");*/
    }

    public void inc() {
        synchronized (someLock) {
            this.version++;
        }
     /*   //TODO: replace method body with real implementation
        throw new UnsupportedOperationException("Not Implemented Yet.");*/
    }

    public void await(int version) throws InterruptedException {
        while(this.version != version){//we wait until the version of our objects equals to the needed version
            try{
                this.wait();
            }catch (InterruptedException ignored){};
        }
        return;


   /*     //TODO: replace method body with real implementation
        throw new UnsupportedOperationException("Not Implemented Yet.");*/
    }
}


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class SafeFile_2{

	static FileReader fr = null;

	public static void sub1(){
		System.out.println("begin");

		File file = null;
		try{
			file = File.createTempFile("rvmonitortest1", ".tmp");
			FileWriter fw_1 = new FileWriter(file);
			fw_1.write("testing\n");
			fw_1.close();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}

		try{
			System.out.println("open");
			fr = new FileReader(file);
			mop.SafeFileRuntimeMonitor.openEvent(fr, Thread.currentThread());
		} catch (Exception e){
		}
		try{
			System.out.println("close");
			fr.close();
			mop.SafeFileRuntimeMonitor.closeEvent(fr, Thread.currentThread());
		} catch (Exception e){
		}
		System.out.println("end");
	}

	public static void sub2(){
		mop.SafeFileRuntimeMonitor.beginCallEvent(Thread.currentThread());
		sub1();
		mop.SafeFileRuntimeMonitor.endCallEvent(Thread.currentThread());
		mop.SafeFileRuntimeMonitor.beginCallEvent(Thread.currentThread());
		sub1();
		mop.SafeFileRuntimeMonitor.endCallEvent(Thread.currentThread());
	}

	public static void main(String[] args){
		for(int i = 0; i < 5; i++){
			mop.SafeFileRuntimeMonitor.beginCallEvent(Thread.currentThread());
			sub1();
			mop.SafeFileRuntimeMonitor.endCallEvent(Thread.currentThread());
		}

		for(int i = 0; i < 2; i++){
			mop.SafeFileRuntimeMonitor.beginCallEvent(Thread.currentThread());
			sub2();
			mop.SafeFileRuntimeMonitor.endCallEvent(Thread.currentThread());
		}

	}

}

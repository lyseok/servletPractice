package basic.vo;

public class MemberVO {
	   private String mem_id;
	   private String mem_pass;
	   private String mem_name;
	   private String mem_tel;
	   private String mem_addr;
	   
	   
	   // VO 클래스의 생성자를 만들 때에는 반드시 기본 생성자도 같이 만들어 준다.
	   public String getMem_id() {
	      return mem_id;
	   }
	   public void setMem_id(String mem_id) {
	      this.mem_id = mem_id;
	   }
	   public String getMem_pass() {
	      return mem_pass;
	   }
	   public void setMem_pass(String mem_pass) {
	      this.mem_pass = mem_pass;
	   }
	   public String getMem_name() {
	      return mem_name;
	   }
	   public void setMem_name(String mem_name) {
	      this.mem_name = mem_name;
	   }
	   public String getMem_tel() {
	      return mem_tel;
	   }
	   public void setMem_tel(String mem_tel) {
	      this.mem_tel = mem_tel;
	   }
	   public String getMem_addr() {
	      return mem_addr;
	   }
	   public void setMem_addr(String mem_addr) {
	      this.mem_addr = mem_addr;
	   }
	   
	   @Override
	   public String toString() {
	      return "MemberVO [mem_id=" + mem_id + ", mem_pass=" + mem_pass + ", mem_name=" + mem_name + ", mem_tel="
	            + mem_tel + ", mem_addr=" + mem_addr + "]";
	   }
	 
	   
	}


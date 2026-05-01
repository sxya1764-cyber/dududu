import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try {
            // 1. ตั้งค่าความสวยงามของฟอนต์
            Font fontTitle = new Font("Tahoma", Font.BOLD, 16);
            Font fontBody = new Font("Tahoma", Font.PLAIN, 14);
            
            UIManager.put("OptionPane.messageFont", fontBody);
            UIManager.put("OptionPane.buttonFont", fontBody);
            UIManager.put("OptionPane.messageForeground", Color.DARK_GRAY);

            // 2. [Action 1] หน้าต่างต้อนรับก่อนเริ่ม
            JOptionPane.showMessageDialog(null, 
                "🔮 ระบบดูดวงจากหมอฟิลม! 🔮\nตั้งจิตอธิษฐานแล้วกดตกลงเพื่อเริ่มทำนาย", 
                "ระบบดูดวง 2026", 
                JOptionPane.PLAIN_MESSAGE);

            // 3. [Action 2] หน้าต่างรับชื่อ
            String name = JOptionPane.showInputDialog(null, 
                "ระบุชื่อของคุณตรงนี้เลยจ้า :", 
                "โปรแกรมดูดวงแม่นจัดแม่นเวอร์", 
                JOptionPane.QUESTION_MESSAGE);

            // ตรวจสอบข้อมูลการกรอก
            if (name != null && !name.trim().isEmpty()) {
                String result = "เป็นแฟนกันมั้ย";
                
                // 4. [Action 3] หน้าต่างแกล้งโหลดประมวลผล (เพิ่มลูกเล่นให้ดูตื่นเต้น)
                JOptionPane.showMessageDialog(null, 
                    "กรุณารอสักครู่...\nระบบกำลังคำนวณวิถีดวงดาวของ '" + name + "' ⏳", 
                    "กำลังประมวลผล...", 
                    JOptionPane.WARNING_MESSAGE);

                // 5. [Action 4] ผลลัพธ์พร้อมไอคอนรูปหัวใจ
                // โหลดไอคอนจาก URL หากไม่มีเน็ตระบบจะแสดงเป็นช่องว่างแทนโดยไม่พัง
                ImageIcon heartIcon = null;
                try {
                    heartIcon = new ImageIcon(new URL("https://imgur.com"));
                } catch (Exception e) {
                    // หากโหลดภาพไม่ได้ ให้ปล่อยผ่าน
                }

                JOptionPane.showMessageDialog(null, 
                    "คุณ " + name + " ดวงของคุณในวันนี้...\n\n💖 '" + result + "' 💖", 
                    "🔮 ผลทำนายดวงชะตา", 
                    JOptionPane.INFORMATION_MESSAGE, 
                    heartIcon);

            } else if (name != null && name.trim().isEmpty()) {
                // กรณีเคาะสเปซบาร์รัวๆ
                JOptionPane.showMessageDialog(null, 
                    "เอ้า! ไม่ใส่ชื่อแล้วจะดูดวงให้ใครล่ะเ จะหลุด", 
                    "แจ้งเตือน", 
                    JOptionPane.ERROR_MESSAGE);
            }
            // ถ้า name == null คือเขากด Cancel หรือกดกากบาทปิด ก็จะปิดโปรแกรมไปเงียบๆ

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

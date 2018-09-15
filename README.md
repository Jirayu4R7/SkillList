# SkillList

#### Demo
<p align="center">
<img src="demo_skillList.gif" width="40%">
</p>

#### การทำงาน
- ข้อมูลใน SkillListFragment จะถูกเก็บใน Shared Preference โดยใช้ GSon แปลง Object ให้เป็น Json เพื่อให้เมื่อกลับมาหน้าแอพฯข้อมูลที่เคยเพิ่มไว้ยังเหลืออยู่
- SkillCatalogItemDialogFragment จะถูกเรียกผ่าน AddSkillFragment เมื่อกดEditText Catalog และ Sub-Catalog พร้อมกับส่งค่า Key เพื่อใช้ในการเรียกข้อมูล catalog มาแสดงใน Recyclerview เพื่อให้ผู้ใช้เลือก เมื่อผู้ใช้กดเลือก Catalog ก็จะเปลี่ยน Text ใน EditText โดยใช้ Interface Class เข้ามาช่วย
- เมื่อกดปุ่ม Save จะเช็ค condition กรอกข้อมูลครบทุกช่อง แล้วจึงส่ง Object Skill ไปยัง SkillListFragment เพื่อให้แสดงผ่านการเพิ่มข้อมูล



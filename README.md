Lab Activity — Interfaces (Java OOP)

## Part A — Concept Check

- **Mengapa kita menggunakan interface?**  
  Karena *interface* adalah **kontrak** yang mendefinisikan perilaku umum (method) yang harus diimplementasikan oleh class. Ini memungkinkan *unrelated classes* berbagi kemampuan yang sama tanpa harus berbagi identitas.

- **Perbedaan inheritance vs interface?**  
  - *Inheritance* = hubungan **is‑a** (contoh: `Dog` is‑a `Animal`).  
  - *Interface* = hubungan **can‑do** (contoh: `Invoice` dan `Employee` can‑do `Payable`).  

- **Mengapa polymorphism penting di interface?**  
  Karena polymorphism memungkinkan kita memperlakukan objek berbeda (`Invoice`, `Employee`) sebagai tipe yang sama (`Payable`), sehingga kode lebih fleksibel dan modular.

---

## Part B — Code Reading

- **Interface definition:**
  ```java
  public interface Payable {
      double getPaymentAmount();
  }
  ```
  Semua class yang mengimplementasikan `Payable` wajib menyediakan method `getPaymentAmount()`.

- **Implementasi pada class `Invoice`:**
  ```java
  public class Invoice implements Payable {
      private int quantity;
      private double pricePerItem;

      @Override
      public double getPaymentAmount() {
          return quantity * pricePerItem;
      }
  }
  ```

- **Implementasi pada class `SalariedEmployee`:**
  ```java
  public class SalariedEmployee extends Employee {
      private double weeklySalary;

      @Override
      public double getPaymentAmount() {
          return weeklySalary;
      }
  }
  ```

- **Mengapa method `getPaymentAmount()` berbeda?**  
  Karena setiap class punya cara sendiri menghitung pembayaran. `Invoice` menghitung dari jumlah barang × harga, sedangkan `Employee` menghitung dari gaji mingguan.

---

## Part C — Interface Polymorphism

- **Contoh penggunaan polymorphism:**
  ```java
  List<Payable> accountsPayable = new ArrayList<>();
  accountsPayable.add(new SalariedEmployee("Alice", "E001", 1200.00));
  accountsPayable.add(new Invoice("Widget-99", 5, 20.00));

  for (Payable item : accountsPayable) {
      System.out.println(item.getPaymentAmount());
  }
  ```

- **Mengapa ini powerful?**  
  Karena kita bisa menyimpan objek berbeda dalam satu collection (`List<Payable>`) dan memanggil method yang sama (`getPaymentAmount()`), tanpa peduli class aslinya.

---

## Part D — Design Note

Interface `Payable` dipilih karena baik `Employee` maupun `Invoice` sama‑sama membutuhkan kemampuan untuk menghitung jumlah pembayaran, meskipun mereka tidak berbagi parent class yang sama. Dengan interface, kita bisa menyatukan perilaku ini dalam satu kontrak, sehingga sistem pembayaran lebih fleksibel dan mudah diperluas.

---

## Summary

- **Interface** = kontrak perilaku (*can‑do*).  
- **Inheritance** = identitas (*is‑a*).  
- **Polymorphism** = memperlakukan objek berbeda sebagai tipe yang sama.  
- Lab ini menunjukkan bagaimana `Employee` dan `Invoice` bisa sama‑sama “dibayar” melalui interface `Payable`.

---

Jadi, inti dari lab ini adalah: **gunakan interface ketika beberapa class berbagi kemampuan yang sama, meskipun mereka tidak berhubungan secara hierarki.**

---

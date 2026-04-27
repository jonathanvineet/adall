import 'package:flutter/material.dart';

void main() => runApp(MaterialApp(home: BudgetHome()));

class Transaction {
  String category;
  double amount;
  bool isIncome;
  Transaction(this.category, this.amount, this.isIncome);
}

class BudgetHome extends StatefulWidget {
  @override
  State<BudgetHome> createState() => _BudgetHomeState();
}

class _BudgetHomeState extends State<BudgetHome> {
  List<Transaction> list = [];
  TextEditingController catCtrl = TextEditingController();
  TextEditingController amtCtrl = TextEditingController();
  bool isIncome = false;

  double get totalIncome  => list.where((t) => t.isIncome).fold(0, (s, t) => s + t.amount);
  double get totalExpense => list.where((t) => !t.isIncome).fold(0, (s, t) => s + t.amount);

  void addEntry() {
    double amt = double.tryParse(amtCtrl.text) ?? 0;
    if (catCtrl.text.isEmpty || amt <= 0) return;
    setState(() => list.add(Transaction(catCtrl.text, amt, isIncome)));
    catCtrl.clear();
    amtCtrl.clear();
    Navigator.pop(context);
  }

  void showForm() => showDialog(
    context: context,
    builder: (_) => AlertDialog(
      title: Text('Add Entry'),
      content: Column(mainAxisSize: MainAxisSize.min, children: [
        TextField(controller: catCtrl, decoration: InputDecoration(labelText: 'Category')),
        TextField(controller: amtCtrl, decoration: InputDecoration(labelText: 'Amount'), keyboardType: TextInputType.number),
        StatefulBuilder(builder: (_, set) => SwitchListTile(
          title: Text(isIncome ? 'Income' : 'Expense'),
          value: isIncome,
          onChanged: (v) => set(() => isIncome = v),
        )),
      ]),
      actions: [
        TextButton(onPressed: () => Navigator.pop(context), child: Text('Cancel')),
        ElevatedButton(onPressed: addEntry, child: Text('Save')),
      ],
    ),
  );

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Budget Tracker')),
      body: Column(children: [
        Text('Income: ₹$totalIncome  |  Expense: ₹$totalExpense  |  Balance: ₹${totalIncome - totalExpense}'),
        Expanded(
          child: ListView.builder(
            itemCount: list.length,
            itemBuilder: (_, i) => ListTile(
              title: Text(list[i].category),
              subtitle: Text(list[i].isIncome ? 'Income' : 'Expense'),
              trailing: Text('₹${list[i].amount}'),
            ),
          ),
        ),
      ]),
      floatingActionButton: FloatingActionButton(onPressed: showForm, child: Icon(Icons.add)),
    );
  }
}

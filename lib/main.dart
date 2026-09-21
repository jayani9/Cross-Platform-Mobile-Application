import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    var orientation = MediaQuery.of(context).orientation;

    return Scaffold(
      appBar: AppBar(
        title: const Text('Sum Calculator'),
        backgroundColor: Colors.blue[600],
      ),
      body: orientation == Orientation.portrait
          ? _portraitLayout()
          : _landscapeLayout(),
    );
  }

  // Portrait layout
  Widget _portraitLayout() {
    return Column(
      children: [
        Container(
          height: 150,
          color: Colors.blue[600],
          child: const Center(
            child: Text(
              '1000.0', // Just a placeholder display
              style: TextStyle(fontSize: 50, color: Colors.white),
            ),
          ),
        ),
        Expanded(
          child: GridView.builder(
            gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
              crossAxisCount: 4, // 4 columns for portrait mode
              crossAxisSpacing: 10,
              mainAxisSpacing: 10,
            ),
            padding: const EdgeInsets.all(10),
            itemCount: 16,
            itemBuilder: (context, index) {
              return CalculatorButton(index);
            },
          ),
        ),
      ],
    );
  }

  // Landscape layout
  Widget _landscapeLayout() {
    return Row(
      children: [
        Container(
          width: 250,
          color: Colors.blue[600],
          child: const Center(
            child: Text(
              '1000.0', // Just a placeholder display
              style: TextStyle(fontSize: 50, color: Colors.white),
            ),
          ),
        ),
        Expanded(
          child: GridView.builder(
            gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
              crossAxisCount: 8, // 8 columns for landscape mode
              crossAxisSpacing: 10,
              mainAxisSpacing: 10,
            ),
            padding: const EdgeInsets.all(10),
            itemCount: 16,
            itemBuilder: (context, index) {
              return CalculatorButton(index);
            },
          ),
        ),
      ],
    );
  }
}

// Calculator Button Widget
class CalculatorButton extends StatelessWidget {
  final int index;

  const CalculatorButton(
    this.index, {
    Key? key, // Fix: added key as a named parameter
  }) : super(key: key); // Fix: passing key to the super constructor

  @override
  Widget build(BuildContext context) {
    final buttonLabels = [
      '7', '8', '9', '/',
      '4', '5', '6', '*',
      '1', '2', '3', '-',
      'C', '0', '=', '+',
    ];

    return ElevatedButton(
      onPressed: () {},
      child: Text(
        buttonLabels[index],
        style: const TextStyle(fontSize: 25),
      ),
      style: ElevatedButton.styleFrom(
        backgroundColor: Colors.black, // Replacing 'primary'
        foregroundColor: Colors.white, // Replacing 'onPrimary'
        padding: const EdgeInsets.symmetric(vertical: 15),
      ),
    );
  }
}

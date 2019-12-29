package lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CapitalCalc extends JFrame {
    public CapitalCalc() {
        setBounds(300, 200, 400, 200);
        setTitle("Capital Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new GridLayout(6, 2));
        JLabel[] labels = new JLabel[5];
        labels[0] = new JLabel("Стартовый капитал, руб");
        labels[1] = new JLabel("Доход за месяц, руб");
        labels[2] = new JLabel("Расход за месяц, руб");
        labels[3] = new JLabel("% ставка ваших инвестиций");
        labels[4] = new JLabel("Инфляция, %");
        JTextField[] txtFields = new JTextField[5];
        double[] amount = new double[5];
        for (int i = 0; i < 5; i++) {
            labels[i].setHorizontalAlignment(JTextField.CENTER);
            add(labels[i]);
            txtFields[i] = new JTextField();
            txtFields[i].setHorizontalAlignment(JTextField.CENTER);
            add(txtFields[i]);
        }
        JButton calc = new JButton("Посчитать");
        calc.setHorizontalAlignment(JTextField.CENTER);
        add(calc);

        //обработка события действий
        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (int i = 0; i < 5; i++) {
                    amount[i] = Double.parseDouble(txtFields[i].getText());
                }
                double startCapital = amount[0];
                double assets = amount[1];
                double liabilities = amount[2];
                double investmentRate = amount[3]/100;
                double yearInvestProfitability = investmentRate + 1;
                double inflation = amount[4]/100 + 1;
                double deltaPercent = (investmentRate/2)*12 + 12;

                double resYear = startCapital*yearInvestProfitability + deltaPercent*(assets - liabilities);
                double resNextYear = resYear+ deltaPercent*(assets - liabilities*inflation);
                double resThreeYear = resNextYear + deltaPercent*(assets - liabilities*Math.pow(inflation,2));
                DecimalFormat df = new DecimalFormat("0.00");
                JOptionPane.showMessageDialog(CapitalCalc.this,
                        new String[] {"Итоговый капитал в конце 1 года: " + df.format(resYear),
                                "Итоговый результат в конце 2 года: " + df.format(resNextYear),
                                "Итоговый результат в конце 3 года: " + df.format(resThreeYear)},
                        "Итог",
                        JOptionPane.PLAIN_MESSAGE);
            }
        });
        setVisible(true);
    }
}
class Main {
    public static void main(String[] args) {
        CapitalCalc capitalCalc = new CapitalCalc();
    }
}
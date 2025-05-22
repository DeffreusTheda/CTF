package com.example.myapplication;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes2.dex */
public class MainActivity extends AppCompatActivity {
    private static int correctAnswersCntr;
    Context MainCtx;
    private EditText inputField1;
    private EditText inputField2;
    private TextView outText;
    private int[] userAnswers;
    int seedQuestions = 0;
    private int currentQuestionIndex = 0;
    ArrayList<Quiz> arrayQuiz = new ArrayList<>();

    public native void callrcv();

    public native String[] generateQuestions();

    public native String[][] getAnswers();

    public native byte[] getCorrectAnswers();

    void QuizSetter() {
        String[] generateQuestions = generateQuestions();
        String[][] answers = getAnswers();
        byte[] correctAnswers = getCorrectAnswers();
        for (int i = 0; i < 10; i++) {
            ArrayList<Quiz> arrayList = this.arrayQuiz;
            String str = generateQuestions[i];
            String[] strArr = answers[i];
            byte b = correctAnswers[i];
            int i2 = b % 4;
            int i3 = b % 4;
            if (i2 <= 0) {
                i3 *= -1;
            }
            arrayList.add(new Quiz(str, strArr, i3));
        }
    }

    private boolean isMyServiceRunning() {
        Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();
        while (it.hasNext()) {
            if (MyService.class.getName().equals(it.next().service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.MainCtx = getApplicationContext();
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new OnApplyWindowInsetsListener() { // from class: com.example.myapplication.MainActivity$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return MainActivity.lambda$onCreate$0(view, windowInsetsCompat);
            }
        });
        System.loadLibrary("laitovayaLiba");
        QuizSetter();
        this.userAnswers = new int[this.arrayQuiz.size()];
        displayQuestion();
        Button button = (Button) findViewById(R.id.option1Button);
        Button button2 = (Button) findViewById(R.id.option2Button);
        Button button3 = (Button) findViewById(R.id.option3Button);
        Button button4 = (Button) findViewById(R.id.option4Button);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.example.myapplication.MainActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.m5427lambda$onCreate$1$comexamplemyapplicationMainActivity(view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.example.myapplication.MainActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.m5428lambda$onCreate$2$comexamplemyapplicationMainActivity(view);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.example.myapplication.MainActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.m5429lambda$onCreate$3$comexamplemyapplicationMainActivity(view);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.example.myapplication.MainActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.m5430lambda$onCreate$4$comexamplemyapplicationMainActivity(view);
            }
        });
    }

    static /* synthetic */ WindowInsetsCompat lambda$onCreate$0(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
        return windowInsetsCompat;
    }

    /* renamed from: lambda$onCreate$1$com-example-myapplication-MainActivity, reason: not valid java name */
    /* synthetic */ void m5427lambda$onCreate$1$comexamplemyapplicationMainActivity(View view) {
        checkAnswer(0);
    }

    /* renamed from: lambda$onCreate$2$com-example-myapplication-MainActivity, reason: not valid java name */
    /* synthetic */ void m5428lambda$onCreate$2$comexamplemyapplicationMainActivity(View view) {
        checkAnswer(1);
    }

    /* renamed from: lambda$onCreate$3$com-example-myapplication-MainActivity, reason: not valid java name */
    /* synthetic */ void m5429lambda$onCreate$3$comexamplemyapplicationMainActivity(View view) {
        checkAnswer(2);
    }

    /* renamed from: lambda$onCreate$4$com-example-myapplication-MainActivity, reason: not valid java name */
    /* synthetic */ void m5430lambda$onCreate$4$comexamplemyapplicationMainActivity(View view) {
        checkAnswer(3);
    }

    private void displayQuestion() {
        Quiz quiz = this.arrayQuiz.get(this.currentQuestionIndex);
        ((TextView) findViewById(R.id.questionTextView)).setText(quiz.getQuestion());
        Button button = (Button) findViewById(R.id.option1Button);
        Button button2 = (Button) findViewById(R.id.option2Button);
        Button button3 = (Button) findViewById(R.id.option3Button);
        Button button4 = (Button) findViewById(R.id.option4Button);
        button.setText(quiz.getAnswer()[0]);
        button2.setText(quiz.getAnswer()[1]);
        button3.setText(quiz.getAnswer()[2]);
        button4.setText(quiz.getAnswer()[3]);
    }

    private void checkAnswer(int i) {
        int[] iArr = this.userAnswers;
        int i2 = this.currentQuestionIndex;
        iArr[i2] = i;
        if (i2 < this.arrayQuiz.size() - 1) {
            if (i == this.arrayQuiz.get(this.currentQuestionIndex).getCorrectAnswer()) {
                correctAnswersCntr++;
            }
            this.currentQuestionIndex++;
            displayQuestion();
            return;
        }
        if (this.currentQuestionIndex == 9) {
            if (correctAnswersCntr == 9) {
                startActivity(new Intent(this, (Class<?>) UnusedActivity.class));
            } else {
                startActivity(new Intent(this, (Class<?>) UnusedActiviy2.class));
                new Timer().schedule(new TimerTask() { // from class: com.example.myapplication.MainActivity.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        MainActivity.this.finishAndRemoveTask();
                    }
                }, 15000L);
            }
        }
    }

    public static int getCorrectAnswersCntr() {
        return correctAnswersCntr;
    }
}

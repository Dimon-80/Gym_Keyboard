package com.example.gymkeyboard;

import static android.view.KeyEvent.KEYCODE_DPAD_UP;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class MyInputMethodService extends InputMethodService implements KeyboardView.OnKeyboardActionListener {
    KeyboardView keyboardView;

//<android.inputmethodservice.KeyboardView     android:keyPreviewLayout="@layout/key_preview"
    @Override
    public View onCreateInputView() {
        keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
        Keyboard keyboard = new Keyboard(this, R.xml.pad_root);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        return keyboardView;
    }


    @Override
    public void onPress(int i) {

    }

    @Override
    public void onRelease(int i) {

    }
    /*https://developer.android.com/develop/ui/views/touch-and-input/keyboard-input/commands
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_D:
                moveShip(MOVE_LEFT);
                return true;
            case KeyEvent.KEYCODE_F:
                moveShip(MOVE_RIGHT);
                return true;
            case KeyEvent.KEYCODE_J:
                fireMachineGun();
                return true;
            case KeyEvent.KEYCODE_K:
                fireMissile();
                return true;
            default:
                return super.onKeyUp(keyCode, event);
        }
    }*/

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection inputConnection = getCurrentInputConnection();
        if (inputConnection != null) {
            switch(primaryCode) {
                case Keyboard.KEYCODE_DELETE :
                    CharSequence selectedText = inputConnection.getSelectedText(0);

                    if (TextUtils.isEmpty(selectedText)) {
                        inputConnection.deleteSurroundingText(1, 0);
                    } else {
                        inputConnection.commitText("", 1);
                    }
                    //keyboardView.getKeyboard().getKeys().get(1).label = "DELETE pressed";
                    break;

                case 999 :
                    Calendar calNow = Calendar.getInstance();
                    Date dateNow = calNow.getTime();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("E, d.M.yy", Locale.forLanguageTag("ru"));
                    String timeNowhms = dateFormat.format(dateNow);
                    inputConnection.commitText(timeNowhms, 1);
                    inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                    break;
//Жим F1
                case -100 :
                    keyboardView.setKeyboard(new Keyboard(this, R.xml.pad_1));
                    keyboardView.invalidateAllKeys();
                    break;

                case -101 :
                    inputConnection.commitText("Жим лежа", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -102 :
                    inputConnection.commitText("Жим лежа на накл скамье", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -103 :
                    inputConnection.commitText("Жим гантелей лежа", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -104 :
                    inputConnection.commitText("Жим гантелей на накл скамье", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -105 :
                    inputConnection.commitText("Жим лежа в тр-ре", 1);
                    enterFkeyInput(inputConnection);
                    break;

                case -106 :
                    inputConnection.commitText("Жим штанги стоя", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -107 :
                    inputConnection.commitText("Жим  штанги сидя", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -108 :
                    inputConnection.commitText("Жим сидя в МС", 1);
                    enterFkeyInput(inputConnection);
                    break;


                case -111 :
                    inputConnection.commitText("Жим гант стоя", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -112 :
                    inputConnection.commitText("Жим гант сидя", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -113 :
                    inputConnection.commitText("Жим Арнольда", 1);
                    enterFkeyInput(inputConnection);
                    break;

                case -116 :
                    inputConnection.commitText("Франц жим лежа", 1);
                    enterFkeyInput(inputConnection);
                    break;

//"Тяга", F2
                case -200 :
                    keyboardView.setKeyboard(new Keyboard(this, R.xml.pad_2));
                    keyboardView.invalidateAllKeys();
                    break;

                case -201 :
                    inputConnection.commitText("Тяга верх бл шир", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -202 :
                    inputConnection.commitText("Тяга верх бл обр", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -203 :
                    inputConnection.commitText("Тяга верх бл пар", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -204 :
                    inputConnection.commitText("Тяга верт рычажная", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -205 :
                    inputConnection.commitText("Тяга верт рычажная одной", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -206 :
                    inputConnection.commitText("Подтягивания шир хв", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -207 :
                    inputConnection.commitText("Подтягивания обр хв", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -208 :
                    inputConnection.commitText("Подтягивания пар хв", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -209 :
                    inputConnection.commitText("Тяга EZ-шт", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -210 :
                    inputConnection.commitText("Тяга шт в накл", 1);
                    enterFkeyInput(inputConnection);
                    break;

                case -211 :
                    inputConnection.commitText("Тяга нижн бл", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -212 :
                    inputConnection.commitText("Тяга гориз рычажная", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -213 :
                    inputConnection.commitText("Тяга гант в накл", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -214 :
                    inputConnection.commitText("Тяга EZ-шт в накл", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -215 :
                    inputConnection.commitText("Тяга шт в накл", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -216 :
                    inputConnection.commitText("Ст тяга", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -217 :
                    inputConnection.commitText("Ст тяга на 1-ой", 1);
                    enterFkeyInput(inputConnection);
                    break;

                case -221 :
                    inputConnection.commitText("Тяга перед собой", 1);
                    enterFkeyInput(inputConnection);
                    break;
//"Приседания", F3
                case -300 :
                    keyboardView.setKeyboard(new Keyboard(this, R.xml.pad_3));
                    keyboardView.invalidateAllKeys();
                    break;

                case -301 :
                    inputConnection.commitText("Приседания", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -302 :
                    inputConnection.commitText("Присед с гант", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -303 :
                    inputConnection.commitText("Болг сплит-присед", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -304 :
                    inputConnection.commitText("Приседания на 1-ой", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -305 :
                    inputConnection.commitText("Жим ногами", 1);
                    enterFkeyInput(inputConnection);
                    break;

//"Выпады", F4
                case -400 :
                    keyboardView.setKeyboard(new Keyboard(this, R.xml.pad_4));
                    keyboardView.invalidateAllKeys();
                    break;

                case -401 :
                    inputConnection.commitText("Выпады с гант", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -402 :
                    inputConnection.commitText("Выпады в МС", 1);
                    enterFkeyInput(inputConnection);
                    break;

//"Разгибание", F5
                case -500 :
                    keyboardView.setKeyboard(new Keyboard(this, R.xml.pad_5));
                    keyboardView.invalidateAllKeys();
                    break;

                case -501 :
                    inputConnection.commitText("Разгиб на блоке", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -502 :
                    inputConnection.commitText("Разгиб на блоке с вер", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -503 :
                    inputConnection.commitText("Разгиб в тренажере", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -504 :
                    inputConnection.commitText("Разгиб с гант стоя", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -505 :
                    inputConnection.commitText("Франц жим лежа", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -506 :
                    inputConnection.commitText("Разгиб-е ног в тр-ре", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -511 :
                    inputConnection.commitText("Гиперэкстензия", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -512 :
                    inputConnection.commitText("Гиперэкстензия на мяче", 1);
                    enterFkeyInput(inputConnection);
                    break;

                case -516 :
                    inputConnection.commitText("Подъемы на носки сидя", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -517 :
                    inputConnection.commitText("Подъемы на носки сидя", 1);
                    enterFkeyInput(inputConnection);
                    break;

//"Сгибание", F6
                case -600 :
                    keyboardView.setKeyboard(new Keyboard(this, R.xml.pad_6));
                    keyboardView.invalidateAllKeys();
                    break;

                case -601 :
                    inputConnection.commitText("Сгиб со шт стоя", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -602 :
                    inputConnection.commitText("Сгиб с EZ-шт", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -603 :
                    inputConnection.commitText("Сгиб с гант стоя", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -604 :
                    inputConnection.commitText("Сгиб с гант сидя накл ск", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -605 :
                    inputConnection.commitText("Сгиб в тр-ре", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -606 :
                    inputConnection.commitText("Сгиб со шт стоя обр хв", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -607 :
                    inputConnection.commitText("Сгиб с EZ-шт стоя обр хв", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -608 :
                    inputConnection.commitText("Молотки", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -611 :
                    inputConnection.commitText("Сгиб-е ног в тр-ре", 1);
                    enterFkeyInput(inputConnection);
                    break;

//"Отведение", F7
                case -700 :
                    keyboardView.setKeyboard(new Keyboard(this, R.xml.pad_7));
                    keyboardView.invalidateAllKeys();
                    break;

                case -701 :
                    inputConnection.commitText("Отв-е ног в тр-ре", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -702 :
                    inputConnection.commitText("Отв-е ноги назад в тр-ре", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -703 :
                    inputConnection.commitText("Отв-е ноги назад в кр-ре", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -704 :
                    inputConnection.commitText("", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -705 :
                    inputConnection.commitText("", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -706 :
                    inputConnection.commitText("Подъемы ч-з стороны", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -707 :
                    inputConnection.commitText("Подъемы ч-з ст в накл", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -708 :
                    inputConnection.commitText("Отв в тр-ре", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -709 :
                    inputConnection.commitText("Отв назад в тр-ре (задняя дельта)", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -710 :
                    inputConnection.commitText("Отв на накл ск", 1);
                    enterFkeyInput(inputConnection);
                    break;

//"Приведение", F8
                case -800 :
                    keyboardView.setKeyboard(new Keyboard(this, R.xml.pad_8));
                    keyboardView.invalidateAllKeys();
                    break;

                case -801 :
                    inputConnection.commitText("Прив-е ног в тр-ре", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -802 :
                    inputConnection.commitText("", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -803 :
                    inputConnection.commitText("", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -804 :
                    inputConnection.commitText("", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -805 :
                    inputConnection.commitText("", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -806 :
                    inputConnection.commitText("Св-е в тр-ре", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -807 :
                    inputConnection.commitText("", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -808 :
                    inputConnection.commitText("", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -809 :
                    inputConnection.commitText("", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -810 :
                    inputConnection.commitText("", 1);
                    enterFkeyInput(inputConnection);
                    break;

//"Пресс", F9
                case -900 :
                    keyboardView.setKeyboard(new Keyboard(this, R.xml.pad_9));
                    keyboardView.invalidateAllKeys();
                    break;

                case -901 :
                    inputConnection.commitText("Обр скручивания", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -902 :
                    inputConnection.commitText("Подъемы ног", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -903 :
                    inputConnection.commitText("Подъемы ног с поворотом", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -904 :
                    inputConnection.commitText("", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -905 :
                    inputConnection.commitText("", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -906 :
                    inputConnection.commitText("Скручивания", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -907 :
                    inputConnection.commitText("Скр-я на полусфере BOSU", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -908 :
                    inputConnection.commitText("Скр на мяче", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -909 :
                    inputConnection.commitText("Скр-я с поворотом", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -910 :
                    inputConnection.commitText("Планка", 1);
                    enterFkeyInput(inputConnection);
                    break;

                case -911 :
                    inputConnection.commitText("Подъемы на рим стуле", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -912 :
                    inputConnection.commitText("Подъемы на рим стуле с поворотом", 1);
                    enterFkeyInput(inputConnection);
                    break;
                case -915 :
                    inputConnection.commitText("Бок планка", 1);
                    enterFkeyInput(inputConnection);
                    break;


//"Реаб", F10
                case -1000 :
                    keyboardView.setKeyboard(new Keyboard(this, R.xml.pad_10));
                    keyboardView.invalidateAllKeys();
                    break;

                case -1001 :
                    inputConnection.commitText("V-подъемы", 1);
                    enterFkeyInput(inputConnection);
                    break;

//return to root pad
                case -10000 :
                        keyboardView.setKeyboard(new Keyboard(this, R.xml.pad_root));
                        keyboardView.invalidateAllKeys();
                    break;







                case -10 :
                    inputConnection.commitText("10", 1);
                    inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                    break;
                case -12 :
                    inputConnection.commitText("12", 1);
                    inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                    break;
                case -15 :
                    inputConnection.commitText("15", 1);
                    inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                    break;
                case -20 :
                    inputConnection.commitText("20", 1);
                    inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                    break;
                case -1100 :
                    inputConnection.commitText("суперсет", 1);
                    inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                    break;
                case -1200 :
                    inputConnection.commitText("дроп-сет", 1);
                    inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                    break;
                case 100500 :
                    inputConnection.commitText("до отказа", 1);
                    inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                    break;

                case 75:
                    inputConnection.commitText("'", 1);
                    break;

                case 81:
                    inputConnection.commitText("+", 1);
                    break;

                case Keyboard.KEYCODE_DONE:
                    Log.d("Keyboard.", "Keyboard.KEYCODE_DONE");
                    inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                    keyboardView.setKeyboard(new Keyboard(this, R.xml.pad_root));
                    keyboardView.invalidateAllKeys();
                    break;

                default :
                    char code = (char) primaryCode;
                    inputConnection.commitText(String.valueOf(code), 1);

            }
            /*Log.d("inputConnection", String.valueOf(inputConnection.getTextBeforeCursor(35, 0)));
            if (inputConnection.getTextBeforeCursor(35, 0) != null) {
                key.label = inputConnection.getTextBeforeCursor(35, 0);
                keyboardView.invalidateAllKeys();
            }
            else  {
                key.label = "";
            }*/
        }

    }

    public void enterFkeyInput(InputConnection inputConnection) {
        inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
        keyboardView.setKeyboard(new Keyboard(this, R.xml.pad_root));
        keyboardView.invalidateAllKeys();
    }

    @Override
    public void onText(CharSequence charSequence) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }
}

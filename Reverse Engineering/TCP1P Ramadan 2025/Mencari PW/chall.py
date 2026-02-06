# Decompiled with PyLingual (https://pylingual.io)
# Internal filename: chall.py
# Bytecode version: 3.13.0rc3 (3571)
# Source timestamp: 1970-01-01 00:00:00 UTC (0)

import tkinter
import string
from tkinter import messagebox

window = tkinter.Tk()
window.title('Login Form')
window.geometry('400x500')
window.configure(bg='#0d0d0d')

password = [
    'qswaefrdthy_gukojplzcxvbmn', 'pkolihu_jyftgrsedwaqmzbxvc',
    'mlnkbjvhcgxfzdsapqowueyr_t', 'plokijuhygtfrdeswaqmnbvcxz',
    'qswdefrgthyjukilopmnbzvcx_', 'qswaefrgthyjukilpom_znxbcv',
    'zqwsedrftgyhuji_kolpxcvbnm', 'qaedwsrf_tgujyhikpomznxbcv',
    'mxnzbcvqsplokwdij_efuhrgyt', 'plokmnzbxvcijuygtfrdeswa_q',
    'plmoknijbuhvygctfxrdzeswaq', 'qazwsxedcrfvtgbyhnujmikol_',
    'wqzsxedcrfvt_gbyhnujmikolp', 'qazwxedcrf_vtgbyhnplmokiju',
    'okmplijnuhbygvtfcrdxewqaz_', 'ygvtfcrd_xeszqaplmoknijbuh',
    'ijnkmpluhbygvtfc_rdxeszwqa', 'tyuioplkjhgfdsaqwezxcvb_nm',
    'mkolpijnuhbygv_tfcrxeszwaq', 'hubijnmkoplygvtfcrdxeszwaq',
    'swxedcr_fvtgbynujmikolpqaz', 'trqwyuioplkjhgfdsazxcvbn_m',
    'klopmijn_ubygvtfcrdxeszaqw', 'bvnmczxlaksjdhfgp_qowiruty'
]

def login():
    username = 'TCP1P'
    entered_username = username_entry.get()
    entered_password = password_entry.get()

    if entered_username != username:
        messagebox.showerror(title='Error', message='Invalid Login')
        return

    # Check each character of entered_password against password list
    for char, pw_string in zip(entered_password, password):
        if char not in pw_string and char not in (string.ascii_lowercase + "_"):
            messagebox.showerror(title='Error', message='masih salah atau coba tambahin underscore mas')
            return

    # If password is correct, show success window
    success_window = tkinter.Toplevel()
    success_window.title("Success")
    success_window.geometry("300x200")
    success_window.configure(bg='#0d0d0d')

    success_label = tkinter.Label(success_window, text="wih gg mas, nih", bg="#0d0d0d", fg="#ff00ff",
                                  font=('Courier', 20, 'bold'))
    success_label.pack(pady=30)

    flag_label = tkinter.Label(success_window, text=f"RAMADHAN{{{entered_password}}}", bg="#0d0d0d", fg="#00ffcc",
                               font=('Courier', 16))
    flag_label.pack(pady=20)

    window.withdraw()  # Hide main window

    # Destroy success window after 5 seconds
    success_window.after(5000, success_window.destroy)
    success_window.mainloop()

frame = tkinter.Frame(bg='#0d0d0d')
login_label = tkinter.Label(frame, text=' Login ', bg='#0d0d0d', fg='#ff00ff', font=('Courier', 30, 'bold'))
username_label = tkinter.Label(frame, text='Username', bg='#0d0d0d', fg='#00ffcc', font=('Courier', 16))
username_entry = tkinter.Entry(frame, font=('Courier', 16), bg='#262626', fg='#00ffcc', insertbackground='#00ffcc', relief='flat')
password_label = tkinter.Label(frame, text='Password', bg='#0d0d0d', fg='#00ffcc', font=('Courier', 16))
password_entry = tkinter.Entry(frame, show='*', font=('Courier', 16), bg='#262626', fg='#00ffcc', insertbackground='#00ffcc', relief='flat')
login_button = tkinter.Button(frame, text='Login cik', bg='#ff00ff', fg='#0d0d0d', font=('Courier', 16), relief='flat', command=login)

login_label.pack(pady=40)
username_label.pack(anchor='w')
username_entry.pack(pady=10, ipadx=50, ipady=5)
password_label.pack(anchor='w')
password_entry.pack(pady=10, ipadx=50, ipady=5)
login_button.pack(pady=30)
frame.pack(expand=True)

window.mainloop()


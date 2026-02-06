import string
password = ['qswaefrdthy_gukojplzcxvbmn', 'pkolihu_jyftgrsedwaqmzbxvc', 'mlnkbjvhcgxfzdsapqowueyr_t', 'plokijuhygtfrdeswaqmnbvcxz', 'qswdefrgthyjukilopmnbzvcx_', 'qswaefrgthyjukilpom_znxbcv', 'zqwsedrftgyhuji_kolpxcvbnm', 'qaedwsrf_tgujyhikpomznxbcv', 'mxnzbcvqsplokwdij_efuhrgyt', 'plokmnzbxvcijuygtfrdeswa_q', 'plmoknijbuhvygctfxrdzeswaq', 'qazwsxedcrfvtgbyhnujmikol_', 'wqzsxedcrfvt_gbyhnujmikolp', 'qazwxedcrf_vtgbyhnplmokiju', 'okmplijnuhbygvtfcrdxewqaz_', 'ygvtfcrd_xeszqaplmoknijbuh', 'ijnkmpluhbygvtfc_rdxeszwqa', 'tyuioplkjhgfdsaqwezxcvb_nm', 'mkolpijnuhbygv_tfcrxeszwaq', 'hubijnmkoplygvtfcrdxeszwaq', 'swxedcr_fvtgbynujmikolpqaz', 'trqwyuioplkjhgfdsazxcvbn_m', 'klopmijn_ubygvtfcrdxeszaqw', 'bvnmczxlaksjdhfgp_qowiruty']
for passwd in password:
    for c in string.ascii_lowercase + "_":
        if c not in passwd:
            print(f"{passwd} -> {c}")
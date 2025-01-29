#!/usr/bin/env python3
from pwn import *

# Mapping kata ke angka
kata_ke_angka = {
    'nol': 0, 'satu': 1, 'dua': 2, 'tiga': 3, 'empat': 4,
    'lima': 5, 'enam': 6, 'tujuh': 7, 'delapan': 8, 'sembilan': 9,
    'sepuluh': 10, 'sebelas': 11, 'duabelas': 12, 'tigabelas': 13,
    'empatbelas': 14, 'limabelas': 15, 'enambelas': 16, 'tujuhbelas': 17,
    'delapanbelas': 18, 'sembilanbelas': 19, 'duapuluh': 20,
    'puluh': 10, 'ratus': 100, 'ribu': 1000, 'juta': 1000000,
    'seratus': 100, 'seribu': 1000
}

def kata_ke_num(kata):
    """Convert kata bahasa Indonesia ke angka"""
    kata = kata.lower().strip()
    
    # Cek direct mapping
    if kata in kata_ke_angka:
        return kata_ke_angka[kata]
    
    # Parse angka kompleks
    total = 0
    current = 0
    
    # Handle seratus, seribu
    if kata.startswith('seratus'):
        total += 100
        kata = kata[7:]
    elif kata.startswith('seribu'):
        total += 1000
        kata = kata[6:]
    
    # Parse digit by digit untuk format seperti "duapuluhlima"
    i = 0
    while i < len(kata):
        found = False
        # Coba match kata terpanjang dulu
        for length in range(min(15, len(kata) - i), 0, -1):
            substr = kata[i:i+length]
            if substr in kata_ke_angka:
                val = kata_ke_angka[substr]
                if val >= 100:  # ratus, ribu, juta
                    if current == 0:
                        current = 1
                    total += current * val
                    current = 0
                elif val == 10:  # puluh
                    current *= 10
                    total += current
                    current = 0
                else:
                    current += val
                i += length
                found = True
                break
        
        if not found:
            i += 1
    
    total += current
    return total

def num_ke_kata(num):
    """Convert angka ke kata bahasa Indonesia"""
    if num == 0:
        return 'nol'
    
    satuan = ['', 'satu', 'dua', 'tiga', 'empat', 'lima', 'enam', 'tujuh', 'delapan', 'sembilan']
    belasan = ['sepuluh', 'sebelas', 'duabelas', 'tigabelas', 'empatbelas', 'limabelas',
               'enambelas', 'tujuhbelas', 'delapanbelas', 'sembilanbelas']
    
    if num < 0:
        return 'minus' + num_ke_kata(-num)
    
    if num < 10:
        return satuan[num]
    elif num < 20:
        return belasan[num - 10]
    elif num < 100:
        puluhan = num // 10
        sisa = num % 10
        if sisa == 0:
            return satuan[puluhan] + 'puluh'
        return satuan[puluhan] + 'puluh' + satuan[sisa]
    elif num < 200:
        sisa = num - 100
        if sisa == 0:
            return 'seratus'
        return 'seratus' + num_ke_kata(sisa)
    elif num < 1000:
        ratusan = num // 100
        sisa = num % 100
        if sisa == 0:
            return satuan[ratusan] + 'ratus'
        return satuan[ratusan] + 'ratus' + num_ke_kata(sisa)
    elif num < 2000:
        sisa = num - 1000
        if sisa == 0:
            return 'seribu'
        return 'seribu' + num_ke_kata(sisa)
    elif num < 1000000:
        ribuan = num // 1000
        sisa = num % 1000
        if sisa == 0:
            return num_ke_kata(ribuan) + 'ribu'
        return num_ke_kata(ribuan) + 'ribu' + num_ke_kata(sisa)
    else:
        jutaan = num // 1000000
        sisa = num % 1000000
        if sisa == 0:
            return num_ke_kata(jutaan) + 'juta'
        return num_ke_kata(jutaan) + 'juta' + num_ke_kata(sisa)

def parse_soal(soal):
    """Parse soal matematika dari format kata"""
    # Hapus decorasi
    soal = soal.replace('█', '').replace('▓', '').replace('▒', '').replace('░', '')
    
    # Extract expression setelah level marker
    if '=' in soal:
        expr = soal.split('=')[0]
        
        # Cari pattern L diikuti angka, lalu ambil setelahnya
        import re
        match = re.search(r'L(\d+)(.*)', expr)
        if match:
            expr = match.group(2).strip()
        else:
            # Fallback: hapus semua yang bukan kata/operator
            expr = re.sub(r'L\d+', '', expr).strip()
    else:
        return None
    
    log.info(f"Expression: {expr}")
    
    # Parse operator dan operand
    # Split berdasarkan operator tapi keep operator
    import re
    tokens = re.split(r'([+\-×x*÷:/])', expr)
    tokens = [t.strip() for t in tokens if t.strip()]
    
    log.info(f"Tokens: {tokens}")
    
    # Proses token pertama
    if not tokens:
        return None
    
    result = kata_ke_num(tokens[0])
    log.info(f"  {tokens[0]} = {result}")
    
    # Proses pasangan operator-operand
    i = 1
    while i < len(tokens):
        if i + 1 >= len(tokens):
            break
        
        operator = tokens[i]
        operand_str = tokens[i + 1]
        operand = kata_ke_num(operand_str)
        
        log.info(f"  {operator} {operand_str} = {operator} {operand}")
        
        if operator == '+':
            result += operand
        elif operator == '-':
            result -= operand
        elif operator in '×x*':
            result *= operand
        elif operator in '÷:/':
            result //= operand
        
        i += 2
    
    return result

# Koneksi ke server
host = '157.230.150.185'  # Ganti dengan host target
port = 12346     # Ganti dengan port target

io = remote(host, port)

# Tunggu intro
io.recvuntil(b'Tekan ENTER untuk memulai...')
io.sendline(b'')

try:
    while True:
        # Terima soal
        data = io.recvuntil(b'=', timeout=5).decode()
        log.info(f"Received: {data}")
        
        # Parse dan hitung
        result = parse_soal(data)
        
        if result is not None:
            # Convert ke kata
            jawaban = num_ke_kata(result)
            log.success(f"Result: {result} = {jawaban}")
            
            # Kirim jawaban
            io.sendline(jawaban.encode())
        else:
            log.error("Failed to parse question")
            break
        
        # Cek response
        response = io.recvline(timeout=2).decode()
        log.info(f"Response: {response}")
        
except EOFError:
    log.info("Connection closed")
    final = io.recvall(timeout=2).decode()
    log.success(f"Final output:\n{final}")

io.close()
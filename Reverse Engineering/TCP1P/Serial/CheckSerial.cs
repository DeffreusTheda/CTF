internal unsafe static bool checkSerial(basic_string < char, std::char_traits < char > , std::allocator < char > \u0020 > * szName, basic_string < char, std::char_traits < char > , std::allocator < char > \u0020 > * szSerial) {
  try {
    try {
      int num = 0;
      int num2 = 0;
      int num3 = 0;
      do {
        int num4 = ((num3 ^ 30866) + 19760 ^ 13345) % 65536;
        if (num4 % 11 == 0) {
          num4 /= 11;
          if (num4 <= 1000) {
            num = num3;
            num2 = num4;
          }
        }
        num3++;
      }
      while (num3 < 65536);
      num3 = 0;
      int LEN = (int)( * (long * )(szName + 16 L / (long) sizeof(basic_string < char, std::char_traits < char > , std::allocator < char > \u0020 > )));
      int num6 = 0;
      if (LEN <= 0) {
        num6 = 0;
      } else {
        int AD_7 = 0;
        int AD_19 = 0;
        int AD_13 = num * 15 % 256;
        int AD_9 = num2 * 17 % 256;
        int ODD_EVEN = 0;
        long CHR_IDX = 0 L;
        long FX_LEN = (long) LEN;
        if (0 L < FX_LEN) {
          basic_string < char, std::char_traits < char > , std::allocator < char > \u0020 > * ptr = (basic_string < char, std::char_traits < char > , std::allocator < char > \u0020 > * )(szName + 24 L / (long) sizeof(basic_string < char, std::char_traits < char > , std::allocator < char > \u0020 > ));
          do {
            long SZNAME_CP = szName;
            if ((( * (long * ) ptr > 15 L) ? 1 : 0) != 0) {
              SZNAME_CP = * (long * ) szName;
            }
            sbyte b = < Module > .toupper((int)( * (SZNAME_CP + CHR_IDX)));
            int num15 = (int)((ulong)( * ((ulong) b * 4 UL + < Module > .TABLE) + num3) % 4294967296 UL);
            if (ODD_EVEN % 2 == 0) {
              uint * ptr2 = (b + 13) * 4 L + < Module > .TABLE;
              uint * ptr3 = (b + 47) * 4 L + < Module > .TABLE;
              uint * ptr4 = (long) AD_9 * 4 L + < Module > .TABLE;
              num15 = (int)((ulong)( * ((long) AD_13 * 4 L + < Module > .TABLE) + ( * ptr2 ^ num15) * * ptr3 + * ptr4) % 4294967296 UL);
              int num16 = (int)((ulong)( * ((long) AD_19 * 4 L + < Module > .TABLE) + num15) % 4294967296 UL);
              num6 = num16;
              num3 = num16;
            } else {
              uint * ptr4 = (b + 63) * 4 L + < Module > .TABLE;
              uint * ptr5 = (b + 23) * 4 L + < Module > .TABLE;
              uint * ptr6 = (long) AD_9 * 4 L + < Module > .TABLE;
              int num17 = (int)((ulong)( * ((long) AD_13 * 4 L + < Module > .TABLE) + ( * ptr4 ^ num15) * * ptr5 + * ptr6) % 4294967296 UL);
              int num18 = (int)((ulong)( * ((long) AD_7 * 4 L + < Module > .TABLE) + num17) % 4294967296 UL);
              num6 = num18;
              num3 = num18;
            }
            AD_19 = (AD_19 + 19) % 256;
            AD_9 = (AD_9 + 9) % 256;
            AD_13 = (AD_13 + 13) % 256;
            AD_7 = (AD_7 + 7) % 256;
            ODD_EVEN++;
            CHR_IDX += 1 L;
          }
          while (CHR_IDX < FX_LEN);
        }
      }
      vector < int, std::allocator < int > \u0020 > vector < int, std::allocator < int > _u0020 >= 0 L;
      *(ref vector < int, std::allocator < int > _u0020 > +8) = 0 L;
      *(ref vector < int, std::allocator < int > _u0020 > +16) = 0 L; <
      Module > .std.vector < int, std::allocator < int > \u0020 > ._Construct_n < > (ref vector < int, std::allocator < int > _u0020 > , 8 L);
      try {
        *(vector < int, std::allocator < int > _u0020 > +16 L) = num6 % 256;
        *(vector < int, std::allocator < int > _u0020 > +20 L) = (num6 >> 8) % 256;
        *(vector < int, std::allocator < int > _u0020 > +24 L) = (num6 >> 16) % 256;
        *(vector < int, std::allocator < int > _u0020 > +28 L) = (num6 >> 24) % 256;
        *(vector < int, std::allocator < int > _u0020 > +12 L) = 156;
        int * ptr7 = vector < int, std::allocator < int > _u0020 > +20 L;
        *(vector < int, std::allocator < int > _u0020 > +8 L) = (num % 256 ^ * ptr7);
        ptr7 = vector < int, std::allocator < int > _u0020 > +28 L;
        *(vector < int, std::allocator < int > _u0020 > +4 L) = (num >> 8 ^ * ptr7);
        ptr7 = vector < int, std::allocator < int > _u0020 > +4 L;
        * vector < int, std::allocator < int > _u0020 >= (( * (vector < int, std::allocator < int > _u0020 > +24 L) ^ * ptr7 ^ 85) % 256 ^ 167);
        sbyte * ptr8 = (sbyte * ) szSerial;
        ulong num19 = (ulong)( * (long * )(szSerial + 24 L / (long) sizeof(basic_string < char, std::char_traits < char > , std::allocator < char > \u0020 > )));
        if (((num19 > 15 UL) ? 1 : 0) != 0) {
          ptr8 = * (long * ) szSerial;
        }
        sbyte * ptr9 = (sbyte * ) szSerial;
        if (((num19 > 15 UL) ? 1 : 0) != 0) {
          ptr9 = * (long * ) szSerial;
        }
        sbyte * ptr10 = (sbyte * ) szSerial;
        if (((num19 > 15 UL) ? 1 : 0) != 0) {
          ptr10 = * (long * ) szSerial;
        }
        sbyte * ptr11 = (sbyte * ) szSerial;
        if (((num19 > 15 UL) ? 1 : 0) != 0) {
          ptr11 = * (long * ) szSerial;
        }
        sbyte * ptr12 = (sbyte * ) szSerial;
        if (((num19 > 15 UL) ? 1 : 0) != 0) {
          ptr12 = * (long * ) szSerial;
        }
        sbyte * ptr13 = (sbyte * ) szSerial;
        if (((num19 > 15 UL) ? 1 : 0) != 0) {
          ptr13 = * (long * ) szSerial;
        }
        sbyte * ptr14 = (sbyte * ) szSerial;
        if (((num19 > 15 UL) ? 1 : 0) != 0) {
          ptr14 = * (long * ) szSerial;
        }
        sbyte * ptr15 = (sbyte * ) szSerial;
        if (((num19 > 15 UL) ? 1 : 0) != 0) {
          ptr15 = * (long * ) szSerial;
        }
        sbyte b2 = * (sbyte * ) ptr8;
        int num20;
        if (b2 >= 48 && b2 <= 57) {
          num20 = (int)(b2 - 48);
        } else {
          num20 = (int)((b2 & -33) - 55);
        }
        b2 = * (sbyte * )(ptr8 + 1 L / (long) sizeof(sbyte));
        int num21;
        if (b2 >= 48 && b2 <= 57) {
          num21 = (int)(b2 - 48);
        } else {
          num21 = (int)((b2 & -33) - 55);
        }
        if ((num20 << 4 | num21) != ( * vector < int, std::allocator < int > _u0020 > & 255)) {
          goto IL_6FC;
        }
        b2 = * (sbyte * )(ptr9 + 2 L / (long) sizeof(sbyte));
        if (b2 >= 48 && b2 <= 57) {
          num20 = (int)(b2 - 48);
        } else {
          num20 = (int)((b2 & -33) - 55);
        }
        b2 = * (sbyte * )(ptr9 + 2 L / (long) sizeof(sbyte) + 1 L / (long) sizeof(sbyte));
        int num22;
        if (b2 >= 48 && b2 <= 57) {
          num22 = (int)(b2 - 48);
        } else {
          num22 = (int)((b2 & -33) - 55);
        }
        if ((num20 << 4 | num22) != ( * (vector < int, std::allocator < int > _u0020 > +4 L) & 255)) {
          goto IL_6FC;
        }
        b2 = * (sbyte * )(ptr10 + 5 L / (long) sizeof(sbyte));
        int num23;
        if (b2 >= 48 && b2 <= 57) {
          num23 = (int)(b2 - 48);
        } else {
          num23 = (int)((b2 & -33) - 55);
        }
        b2 = * (sbyte * )(ptr10 + 5 L / (long) sizeof(sbyte) + 1 L / (long) sizeof(sbyte));
        int num24;
        if (b2 >= 48 && b2 <= 57) {
          num24 = (int)(b2 - 48);
        } else {
          num24 = (int)((b2 & -33) - 55);
        }
        if ((num23 << 4 | num24) != ( * (vector < int, std::allocator < int > _u0020 > +8 L) & 255)) {
          goto IL_6FC;
        }
        b2 = * (sbyte * )(ptr11 + 7 L / (long) sizeof(sbyte));
        int num25;
        if (b2 >= 48 && b2 <= 57) {
          num25 = (int)(b2 - 48);
        } else {
          num25 = (int)((b2 & -33) - 55);
        }
        b2 = * (sbyte * )(ptr11 + 7 L / (long) sizeof(sbyte) + 1 L / (long) sizeof(sbyte));
        int num26;
        if (b2 >= 48 && b2 <= 57) {
          num26 = (int)(b2 - 48);
        } else {
          num26 = (int)((b2 & -33) - 55);
        }
        if ((num25 << 4 | num26) != ( * (vector < int, std::allocator < int > _u0020 > +12 L) & 255)) {
          goto IL_6FC;
        }
        b2 = * (sbyte * )(ptr12 + 10 L / (long) sizeof(sbyte));
        int num27;
        if (b2 >= 48 && b2 <= 57) {
          num27 = (int)(b2 - 48);
        } else {
          num27 = (int)((b2 & -33) - 55);
        }
        b2 = * (sbyte * )(ptr12 + 10 L / (long) sizeof(sbyte) + 1 L / (long) sizeof(sbyte));
        int num28;
        if (b2 >= 48 && b2 <= 57) {
          num28 = (int)(b2 - 48);
        } else {
          num28 = (int)((b2 & -33) - 55);
        }
        if ((num27 << 4 | num28) != ( * (vector < int, std::allocator < int > _u0020 > +16 L) & 255)) {
          goto IL_6FC;
        }
        b2 = * (sbyte * )(ptr13 + 12 L / (long) sizeof(sbyte));
        int num29;
        if (b2 >= 48 && b2 <= 57) {
          num29 = (int)(b2 - 48);
        } else {
          num29 = (int)((b2 & -33) - 55);
        }
        b2 = * (sbyte * )(ptr13 + 12 L / (long) sizeof(sbyte) + 1 L / (long) sizeof(sbyte));
        int num30;
        if (b2 >= 48 && b2 <= 57) {
          num30 = (int)(b2 - 48);
        } else {
          num30 = (int)((b2 & -33) - 55);
        }
        if ((num29 << 4 | num30) != ( * (vector < int, std::allocator < int > _u0020 > +20 L) & 255)) {
          goto IL_6FC;
        }
        b2 = * (sbyte * )(ptr14 + 15 L / (long) sizeof(sbyte));
        int num31;
        if (b2 >= 48 && b2 <= 57) {
          num31 = (int)(b2 - 48);
        } else {
          num31 = (int)((b2 & -33) - 55);
        }
        b2 = * (sbyte * )(ptr14 + 15 L / (long) sizeof(sbyte) + 1 L / (long) sizeof(sbyte));
        int num32;
        if (b2 >= 48 && b2 <= 57) {
          num32 = (int)(b2 - 48);
        } else {
          num32 = (int)((b2 & -33) - 55);
        }
        if ((num31 << 4 | num32) != ( * (vector < int, std::allocator < int > _u0020 > +24 L) & 255)) {
          goto IL_6FC;
        }
        b2 = * (sbyte * )(ptr15 + 17 L / (long) sizeof(sbyte));
        int num33;
        if (b2 >= 48 && b2 <= 57) {
          num33 = (int)(b2 - 48);
        } else {
          num33 = (int)((b2 & -33) - 55);
        }
        b2 = * (sbyte * )(ptr15 + 17 L / (long) sizeof(sbyte) + 1 L / (long) sizeof(sbyte));
        int num34;
        if (b2 >= 48 && b2 <= 57) {
          num34 = (int)(b2 - 48);
        } else {
          num34 = (int)((b2 & -33) - 55);
        }
        if ((num33 << 4 | num34) != ( * (vector < int, std::allocator < int > _u0020 > +28 L) & 255)) {
          goto IL_6FC;
        }
      } catch {
        <
        Module > .___CxxCallUnwindDtor(ldftn(std.vector < int, std::allocator < int > \u0020 > . {
          dtor
        }), (void * )( & vector < int, std::allocator < int > _u0020 > ));
        throw;
      } <
      Module > .std.vector < int, std::allocator < int > \u0020 > ._Tidy(ref vector < int, std::allocator < int > _u0020 > );
    } catch {
      <
      Module > .___CxxCallUnwindDtor(ldftn(std.basic_string < char, std::char_traits < char > , std::allocator < char > \u0020 > . {
        dtor
      }), (void * ) szName);
      throw;
    }
    try {
      <
      Module > .std.basic_string < char, std::char_traits < char > , std::allocator < char > \u0020 > ._Tidy_deallocate(szName);
    } catch {
      <
      Module > .___CxxCallUnwindDtor(ldftn(std._Compressed_pair < std::allocator < char > , std::_String_val < std::_Simple_types < char > \u0020 > , 1 > . {
        dtor
      }), (void * ) szName);
      throw;
    }
  } catch {
    <
    Module > .___CxxCallUnwindDtor(ldftn(std.basic_string < char, std::char_traits < char > , std::allocator < char > \u0020 > . {
      dtor
    }), (void * ) szSerial);
    throw;
  }
  try {
    <
    Module > .std.basic_string < char, std::char_traits < char > , std::allocator < char > \u0020 > ._Tidy_deallocate(szSerial);
  } catch {
    <
    Module > .___CxxCallUnwindDtor(ldftn(std._Compressed_pair < std::allocator < char > , std::_String_val < std::_Simple_types < char > \u0020 > , 1 > . {
      dtor
    }), (void * ) szSerial);
    throw;
  }
  return 1;
  IL_6FC:
    try {
      try {
        vector < int, std::allocator < int > \u0020 > vector < int, std::allocator < int > _u0020 > ; <
        Module > .std.vector < int, std::allocator < int > \u0020 > ._Tidy(ref vector < int, std::allocator < int > _u0020 > );
      } catch {
        <
        Module > .___CxxCallUnwindDtor(ldftn(std.basic_string < char, std::char_traits < char > , std::allocator < char > \u0020 > . {
          dtor
        }), (void * ) szName);
        throw;
      }
      try {
        <
        Module > .std.basic_string < char, std::char_traits < char > , std::allocator < char > \u0020 > ._Tidy_deallocate(szName);
      } catch {
        <
        Module > .___CxxCallUnwindDtor(ldftn(std._Compressed_pair < std::allocator < char > , std::_String_val < std::_Simple_types < char > \u0020 > , 1 > . {
          dtor
        }), (void * ) szName);
        throw;
      }
    }
  catch {
    <
    Module > .___CxxCallUnwindDtor(ldftn(std.basic_string < char, std::char_traits < char > , std::allocator < char > \u0020 > . {
      dtor
    }), (void * ) szSerial);
    throw;
  }
  try {
    <
    Module > .std.basic_string < char, std::char_traits < char > , std::allocator < char > \u0020 > ._Tidy_deallocate(szSerial);
  } catch {
    <
    Module > .___CxxCallUnwindDtor(ldftn(std._Compressed_pair < std::allocator < char > , std::_String_val < std::_Simple_types < char > \u0020 > , 1 > . {
      dtor
    }), (void * ) szSerial);
    throw;
  }
  return 0;
}
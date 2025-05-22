nt num7 = 0;
int num8 = 0;
int num9 = num * 15 % 256;
int num10 = num2 * 17 % 256;
int num11 = 0;
long num12 = 0L;
long num13 = (long)num5;
if 0L < num13:
    basic_string<char,std::char_traits<char>,std::allocator<char>\u0020>* ptr = (basic_string<char,std::char_traits<char>,std::allocator<char>\u0020>*)(szName + 24L / (long)sizeof(basic_string<char,std::char_traits<char>,std::allocator<char>\u0020>));
    do
    {
        long num14 = szName;
        if (((*(long*)ptr > 15L) ? 1 : 0) != 0)
        {
            num14 = *(long*)szName;
        }
        sbyte b = <Module>.toupper((int)(*(num14 + num12)));
        int num15 = (int)((ulong)(*((ulong)b * 4UL + <Module>.TABLE) + num3) % 4294967296UL);
        if (num11 % 2 == 0)
        {
            uint* ptr2 = (b + 13) * 4L + <Module>.TABLE;
            uint* ptr3 = (b + 47) * 4L + <Module>.TABLE;
            uint* ptr4 = (long)num10 * 4L + <Module>.TABLE;
            num15 = (int)((ulong)(*((long)num9 * 4L + <Module>.TABLE) + (*ptr2 ^ num15) * *ptr3 + *ptr4) % 4294967296UL);
            int num16 = (int)((ulong)(*((long)num8 * 4L + <Module>.TABLE) + num15) % 4294967296UL);
            num6 = num16;
            num3 = num16;
        }
        else
        {
            uint* ptr4 = (b + 63) * 4L + <Module>.TABLE;
            uint* ptr5 = (b + 23) * 4L + <Module>.TABLE;
            uint* ptr6 = (long)num10 * 4L + <Module>.TABLE;
            int num17 = (int)((ulong)(*((long)num9 * 4L + <Module>.TABLE) + (*ptr4 ^ num15) * *ptr5 + *ptr6) % 4294967296UL);
            int num18 = (int)((ulong)(*((long)num7 * 4L + <Module>.TABLE) + num17) % 4294967296UL);
            num6 = num18;
            num3 = num18;
        }
        num8 = (num8 + 19) % 256;
        num10 = (num10 + 9) % 256;
        num9 = (num9 + 13) % 256;
        num7 = (num7 + 7) % 256;
        num11++;
        num12 += 1L;
    }
    while (num12 < num13);
}
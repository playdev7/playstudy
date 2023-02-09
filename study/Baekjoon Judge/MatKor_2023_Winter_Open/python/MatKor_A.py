# MatKor - A 번

time, soju = map(int, input().split())

if soju==1 or not 12<=time<=16:
    print(280)

elif 12<=time<=16 and soju==0:
    print(320)
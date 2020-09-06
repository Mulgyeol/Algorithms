def fibo(n):
	a = 1
	b = 1
	c = 0
	if n <= 1:
		return 1
	else:
		while n != 1:
			c = a + b
			b = a
			a = c
			n = n-1
		return a
	
n = int(input())
print(fibo(n))
	

# n을 입력받은 후
# fibo(n) 호출!
# 리턴값을 출력함
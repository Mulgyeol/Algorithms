import heapq

n = int(input())
m = int(input())

w = [[] for i in range(n)]
for i in range(m):
	a,b,c = map(int,input().split())
	w[a].append((b,c))
	

S = 0
dist = [9999]*n
dist[0] = 0
parent = ['None']*n
Q = []
for v in range(n):
	heapq.heappush(Q, (dist[v],v))
	


while (len(Q) != 0):
	u = heapq.heappop(Q)
	u = u[1]
	for v in w[u]:
		if dist[v[0]] > dist[u] + v[1]:
			dist[v[0]] = dist[u] + v[1]

		for i in range(len(Q)):
			if Q[i][1] == v[0]:
				Q[i] = (dist[v[0]],v[0])
	
	heapq.heapify(Q)
	
	


	

for i in dist:
	if i != 9999:
		print(i,end = " ")
	else:
		print("inf", end =" ")
		

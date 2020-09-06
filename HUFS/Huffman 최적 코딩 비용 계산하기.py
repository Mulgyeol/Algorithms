import heapq

H = []
cost = 0
list_n = list(map(int, input().split()))
for x in range(len(list_n)):
    heapq.heappush(H, (list_n[x], str(x)))
             
while (len(H) > 1):
    a = heapq.heappop(H)
    b = heapq.heappop(H)
    heapq.heappush(H, (a[0] + b[0], '('+a[1]+' '+b[1]+')'))
tree_string = heapq.heappop(H)[1]
						 

count = 0
temp = ''
for i in range(len(tree_string)):
	if tree_string[i] == '(':
		count += 1
		temp = ''
	if tree_string[i] == ')':
		count -= 1
		temp = ''
	if tree_string[i] == ' ':
		temp = ''
	if tree_string[i] != '(' and tree_string[i] != ')' and tree_string[i] != ' ' and i < len(tree_string):
		temp += tree_string[i]
		if tree_string[i+1] == '(' or tree_string[i+1] == ')' or tree_string[i+1] == ' ':
			cost += list_n[int(temp)] * count
			
print(cost)

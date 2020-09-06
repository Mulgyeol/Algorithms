def solution(array, commands):
    answer = []
    for i in range(len(commands)):
        new_list = array[commands[i][0]-1:commands[i][1]]
        new_list.sort()
        answer.append(new_list[commands[i][2]-1])
    return answer


# 다른 사람의 풀이(람다식, 여러 변수에 한꺼번에 대입, sorted)
# def solution(array, commands):
#     return list(map(lambda x:sorted(array[x[0]-1:x[1]])[x[2]-1], commands))


# def solution(array, commands):
#     answer = []
#     for command in commands:
#         i,j,k = command
#         answer.append(list(sorted(array[i-1:j]))[k-1])
#     return answer

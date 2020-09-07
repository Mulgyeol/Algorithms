# 문제 잘 읽기
# 잃어버린 사람도 여분이 있을 수 있다.
# 잃어버렸지만 여분이 있는 사람은 다른 사람에게 빌려주지 못한다.
# 뒤에서 터 확인하도록 했기 때문에 뒷사람이 먼저 있는지 확인하고, 앞을 확인한다.
# 전체를 다 할 필요없고 lost만 뒤져도 reserve나 lost 하나를 기준으로 잡고만 해도 됨.

def solution(n, lost, reserve):
    answer = 0

    for i in range(n,0,-1):
        if i in lost:
            if i in reserve:
                lost.remove(i)
                reserve.remove(i)

    for i in range(n,0,-1):
        if i in lost:
            if i+1 in reserve:
                lost.remove(i)
                reserve.remove(i+1)
                continue

            if i-1 in reserve:
                lost.remove(i)
                reserve.remove(i-1)


    answer = n - len(lost)

    return answer

# 다른 사람 풀이 참고 후 나름 간결하게
def solution(n, lost, reserve):
    new_lost = list(set(lost) - set(reserve))
    new_reserve = list(set(reserve) - set(lost))
    
    for i in new_reserve:
        if i-1 in new_lost:
            new_lost.remove(i-1)
            continue
            
        if i+1 in new_lost:
            new_lost.remove(i+1)

    answer = n - len(new_lost)
    return answer



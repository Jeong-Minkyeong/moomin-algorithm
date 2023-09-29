def solution(todo_list, finished):
    todo = dict(zip(todo_list, finished))
    answer = [ key for key, item in todo.items() if item == False]
    return answer
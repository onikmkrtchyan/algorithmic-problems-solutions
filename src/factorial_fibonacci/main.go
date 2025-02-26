package main

func factorial(n int) int {
	fact := 1
	for i := 1; i <= n; i++ {
		fact *= i
	}

	return fact
}

func factorialRec(n int) int {
	if n <= 1 {
		return 1
	}

	return n * factorialRec(n-1)
}

func fibonacci(n int) int {
	if n == 0 {
		return 0
	}
	a, b := 0, 1
	for i := 2; i <= n; i++ {
		temp := a + b
		a = b
		b = temp
	}
	return b
}

func fibonacciRec(n int) int {
	if n <= 0 {
		return 0
	}

	if n == 1 || n == 2 {
		return 1
	}

	return fibonacciRec(n-1) + fibonacciRec(n-2)
}

func fibonacciCache(n int) int {
	cache := make([]int, n+1)
	return fibonacciCache1(n, cache)
}

func fibonacciCache1(n int, cache []int) int {
	if n <= 0 {
		return 0
	}

	if n == 1 || n == 2 {
		return 1
	}

	if cache[n] == 0 {
		cache[n] = fibonacciCache1(n-1, cache) + fibonacciCache1(n-2, cache)
	}

	return cache[n]
}

func main() {
	println(factorial(5))
	println(factorialRec(5))

	println(fibonacci(7))      // 0 1 1 2 3 5 8 13
	println(fibonacciRec(7))   // 0 1 1 2 3 5 8 13
	println(fibonacciCache(7)) // 0 1 1 2 3 5 8 13
}

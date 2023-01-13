		var numbers = [2, 4, 6, 8, 10];
		addResult(numbers); // addResult 함수 실행
		showArray(numbers);

		function showArray(arr) {
			var str = "<table><tr>";
			for (var i=0; i<arr.length; i++) {
				str += "<td>" + arr[i] + "</td>";
			}
			str += "</tr></table>";
			document.write(str);
		}

		// 배열의 모든 정수를 더해서 끝에 추가해주는 addResult 함수 선언 및 정의.
		function addResult(arr) {
			var result = 0;
			for(i=0; i<arr.length; i++) {	// 배열의 길이만큼 반복.
				
				result += parseInt(arr[i]);		// 배열 요소 정수 아닌줄 알고 parseInt() 사용.. :)
			}
			arr.push(result);
		}

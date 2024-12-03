package algorithm_practice;

import java.util.*;

// WrapperClass(기본 자료형), 문자열만을 키값으로 했을 때 바로 찾을 수 있음.

public class Hashmap_Hashset {
	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{
			put(1, 2); 
			put(2, -1);
			}};
		
		Map<Integer, List<Integer>> map2 = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		
		System.out.println(map.size());
		System.out.println(map);
		
		//-------------------HashMap-------------------
		
		// 값 삽입
		// 얘만 좀 다른 듯
		map.put(200,  -1);
		System.out.println(map);

		// 값 조회
		
		// Map.get()은 키 값의 hashCode()로 비교. 
		// Wrapper클래스의 hashCode()는 value를 비교. 
		// 그래서 키값이 기본자료형(->WrapperClass)이면 get으로 key값만 매칭 성공.
		
		// Object클래의 hashCode()는 value값을 비교 안 함. 무슨 내용인지는 잘 모르겠음. 
		// Array도 value값을 비교 안 함
		// WrapperClass(기본 자료형), 문자열만을 키값으로 했을 때 바로 찾을 수 있음.
		
		// 만약 꼭 다른 종류의 자료형을 넣는다면 레퍼런스를 배열로 따로 저장해놓고 접근가능. 
		// 그치만 지양하자. 이왕이면 문자열로 변환시키거나 해서 쓰자. 
		int output = map.get(200);
		System.out.println(output);
		
		// 값 삭제
		map.remove(200);
		System.out.println(map);
		
		
		// 전체 값 조회
		System.out.println(map);
		
		// 비어있는지 확인
		System.out.println(map.isEmpty());
		
		// 키 값 얻기
		System.out.println(map.keySet());
		
		// 벨류 값 얻기
		System.out.println(map.values());
		
		
		// 벨류 리스트에 값 추가하기
		map2.put(1, new ArrayList<>(Arrays.asList(1, 2, 3)));
		
		if (!map2.containsKey(1)) {
			map2.put(1, new ArrayList<>());
		}
		
		map2.get(1).add(6);
		System.out.println(map2);
		
		
		//-----------------hashSet-------------------

		System.out.println("-----------hashSet-----------");
		
		// 값 삽입
		set.add(1);
		set.add(3);
		set.add(2);
		System.out.println(set);
		
		// 값 삭제
		set.remove(1);
		System.out.println(set);
		
		// 원소 조회하기
		Iterator iter = set.iterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
	}
}
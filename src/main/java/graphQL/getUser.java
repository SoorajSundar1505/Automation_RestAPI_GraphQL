package graphQL;

import lombok.Builder;


public class getUser {
	public static String getUserQuery() {
		return "{\"variables\":{},\"query\":\"{\\n  user(id: 1) {\\n    id\\n    username\\n    email\\n    address {\\n      geo {\\n        lat\\n        lng\\n        __typename\\n      }\\n      __typename\\n    }\\n    __typename\\n  }\\n}\"}";
	}
	
}

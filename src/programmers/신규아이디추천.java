// ���α׷��ӽ� : �űԾ��̵� ��õ

class Solution {
    public String solution(String new_id) {
        String id = new_id.toLowerCase(); // �ҹ��ڷ� 
        id = id.replaceAll("[^-_.a-z0-9]", ""); //-_. ������ ���ڸ� ���� 
        id = id.replaceAll("[.]{2,}", "."); // .2�� �̻� .���� 
        id = id.replaceAll("^[.]|[.]$", ""); // ó���� �� . ���� 

        if(id.equals("")) // �� ���ڿ��̶�� a �߰� 
            id += "a";
            
        if(id.length() >= 16){ // 16�� �̻��̸� 15�ڷ� 
            id = id.substring(0, 15);
            id = id.replaceAll("^[.]|[.]$", ""); // �� . ���� 
        }
        if(id.length() <= 2) // 2�� ���϶�� 3�ڱ��� ������ �����߰� 
            while(id.length() < 3)
                id += id.charAt(id.length() - 1);

        return id;
    }
}
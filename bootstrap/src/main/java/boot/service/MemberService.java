package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.MemberRepository;
import boot.model.Member;



@Service @Transactional
public class MemberService {

	private final MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository){
		super();
		this.memberRepository= memberRepository;
	}
	
	public List <Member> findAll(){
		List<Member> members = new ArrayList<Member>();
		for(Member member : memberRepository.findAll() ){
			members.add(member);
		}
		return members;
	}
	
	public void save(Member member){
		memberRepository.save(member);
	}
	
	public void delete(int id){
		memberRepository.delete(id);
	}
	
	public  Member finOne(int id){
	return memberRepository.findOne(id);
	}
}

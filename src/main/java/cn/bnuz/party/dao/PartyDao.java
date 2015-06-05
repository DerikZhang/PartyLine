package cn.bnuz.party.dao;

import java.util.List;

import cn.bnuz.party.vo.Party;
import cn.bnuz.party.vo.Result;
import cn.bnuz.party.vo.User;

public interface PartyDao {

	Result addParty(Party inParty);

	boolean update(Party inParty);

	Result addUserToParty(List<User> userList,Party party);

	Result getPartyUser(Party party);

	boolean partyIsExist(Party party);

	Result getPartyInfo(String partyID);

	Party getPartyByPrimaryKey(int p_id);

	List<Party> getAllParty();
}

package com.daoben.rfid.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.daoben.rfid.model.AssetInfoHis;
import com.daoben.rfid.model.InfoHis;

@Repository
public interface AssetInfoHisMapper {
	public List<InfoHis> selectAllAssetInfoHis(String asset_Type);

	public List<InfoHis> selectByTagIdInfo(String tag_Id);

	public int insertAssetInfoHis(AssetInfoHis aHis);

	public int updateAssetInfoHis(AssetInfoHis aHis);

	public int deleteAssetInfoHis(String tag_Id);

	public List<Map<String, String>> selectByTagType(String tag_Id);

	public List<Map<String, String>> unionAssetIoLibrary(String asset_Type);

	public List<Map<String, Object>> unionAssetIoLibraryTagId(AssetInfoHis aHis);
	
	public List<Map<String, Object>> selectAssetInfoHisType();
	
	
	public List<InfoHis> selectAll();
}
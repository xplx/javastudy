package com.daoben.rfid.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.daoben.rfid.mapper.AssetInfoHisMapper;
import com.daoben.rfid.model.AssetInfoHis;
import com.daoben.rfid.model.InfoHis;
import com.daoben.rfid.utils.AcquireTimeStamp;

/**
 * @author wxp
 *
 */
@Service
public class AssetInfoHisService {

	@Resource
	private AssetInfoHisMapper aMapper;

	@Resource
	AcquireTimeStamp aStamp;

	/**
	 * @author wxp 查询所有的设备信息
	 */
	public List<InfoHis> selectAllAssetInfoHis(String asset_typr) {

		return aMapper.selectAllAssetInfoHis(asset_typr);
	}

	/**
	 * @author wxp 查询所有的设备信息
	 */
	public List<InfoHis> selectByTagIdInfo(String tag_Id) {

		return aMapper.selectByTagIdInfo(tag_Id);
	}

	/**
	 * @author wxp 查询所有的设备信息
	 */
	public int insertAssetInfoHis(AssetInfoHis aHis) {

		return aMapper.insertAssetInfoHis(aHis);
	}

	/**
	 * @author wxp 查询所有的设备信息
	 */
	public int updateAssetInfoHis(AssetInfoHis aHis) {

		return aMapper.updateAssetInfoHis(aHis);
	}

	/**
	 * @author wxp 查询所有的设备信息
	 */
	public int deleteAssetInfoHis(String tag_Id) {

		return aMapper.deleteAssetInfoHis(tag_Id);
	}

	/**
	 * @author wxp 查询所有的设备信息
	 */
	public List<Map<String, String>> selectByTagType(String tag_Id) {

		return aMapper.selectByTagType(tag_Id);
	}

	/**
	 * @author wxp 查询所有的设备信息
	 */
	public List<Map<String, String>> unionAssetIoLibrary(String asset_Type) {

		return aMapper.unionAssetIoLibrary(asset_Type);
	}

	/**
	 * @author wxp 查询所有的设备信息
	 */
	public List<Map<String, Object>> unionAssetIoLibraryTagId(AssetInfoHis aHis) {

		return aMapper.unionAssetIoLibraryTagId(aHis);
	}

	/**
	 * @author wxp 查询设备类型数量
	 */
	public List<Map<String, Object>> selectAssetInfoHisType() {

		return aMapper.selectAssetInfoHisType();
	}
	/**
	 * 练习
	 * @return
	 */
	public List<InfoHis> selectAll(){
		return aMapper.selectAll();
	}
}

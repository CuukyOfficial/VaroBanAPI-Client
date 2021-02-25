package de.varoplugin.banapi.request;

import de.varoplugin.banapi.BanApi;
import de.varoplugin.banapi.BanMeta;

public class SetBanMetaRequest extends SupplierRequest {

	public SetBanMetaRequest(BanApi api, BanMeta meta) {
		super(api, "setmeta", api.getGson().toJson(meta));
	}
}
